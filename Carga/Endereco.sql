#macro = 4200-ENDERECO
$SHOW_SCENE=false
$SHOW_STATUS=false

#source = db1-TCC.conf
select random(999999999) as proc_id


#source = db1-TCC.conf
$SHOW_SQL=true
select 'u.localidade IS NOT NULL'::text as filtro,
	   '@$Multiop{ (u.localidade,setor,bairro,u.logradouro) > (@localidade,@setor,@bairro,@logradouro) }' as partida;
 
#source = db1-TCC.conf
$REPEAT_WHILE_FOUND=true

$SHOW_SQL=true
select
u.localidade as localidade,
setor,
bairro,
nome_bairro,
u.logradouro as logradouro,
nome_logradouro,
 nome_municipio,
 uf,
 latitude,
 longitude 
 from tmp_loc_usuario u
left join tmp_servicos_cep c on u.localidade = c.localidade and u.logradouro = c.logradouro

where @filtro::native
      @query=db1-TCC.conf{select ' and ('||condicaopartida||')' from bi.relatorio_carga
                    where tipo = 2 and escopo = @filtro order by id desc limit 1 }::native


order by u.localidade,setor,bairro,u.logradouro

limit 1

#if found = 1
repeat;

#if not found  
stop;

#target = db1-TCC.conf
$BATCH_SIZE=10
$SHOW_SQL=false
$LABEL=INSERT @#rowid: localidade=@localidade, setor = @setor, bairro = @bairro, logradouro = @logradouro


insert into bi.endereco_solicitacao
(
localidade, setor, bairro, nome_bairro, logradouro, nome_logradouro,  nome_municipio, uf,latitude,longitude 
) 
values
(
@localidade, @setor, @bairro, @nome_bairro, @logradouro, @nome_logradouro,  @nome_municipio, @uf, @latitude,@longitude
) on conflict (localidade,setor,bairro,logradouro) do nothing 

#afterlast = db1-TCC.conf
$RECURSIVE_REFERENCE=true
insert into bi.relatorio_carga (tipo, escopo, updatedregistro, registros, condicaopartida, proc_id)
values (2, @filtro, now(), @#rowid, @partida, @proc_id);