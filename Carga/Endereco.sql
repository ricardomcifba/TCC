#macro = 4200-ENDERECO
$SHOW_SCENE=false
$SHOW_STATUS=false

#source = db1-TCC.conf
select random(999999999) as proc_id


#source = db1-TCC.conf
$SHOW_SQL=true
select 'localidade IS NOT NULL'::text as filtro,
	   '@$Multiop{ (localidade,setor,bairro,logradouro) > (@localidade,@setor,@bairro,@logradouro) }' as partida;
 
#source = db1-TCC.conf
$REPEAT_WHILE_FOUND=true

$SHOW_SQL=false
select distinct 
localidade,
setor,
bairro,
nome_bairro,
logradouro,
nome_logradouro,
 nome_municipio,
 uf 
 from tmp_loc_usuario 

where @filtro::native
      @query=db1-TCC.conf{select ' and ('||condicaopartida||')' from bi.relatorio_carga
                    where tipo = 2 and escopo = @filtro order by id desc limit 1 }::native


order by localidade,setor,bairro,logradouro

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
localidade, setor, bairro, nome_bairro, logradouro, nome_logradouro,  nome_municipio, uf 
) 
values
(
@localidade, @setor, @bairro, @nome_bairro, @logradouro, @nome_logradouro,  @nome_municipio, @uf 
) on conflict (localidade,setor,bairro,logradouro) do nothing 

#afterlast = db1-TCC.conf
$RECURSIVE_REFERENCE=true
insert into bi.relatorio_carga (tipo, escopo, updatedregistro, registros, condicaopartida, proc_id)
values (2, @filtro, now(), @#rowid, @partida, @proc_id);