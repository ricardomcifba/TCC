#macro = 4200-SERVICO
$SHOW_SCENE=false
$SHOW_STATUS=false

#source = db1-TCC.conf

select random(999999999) as proc_id


#source = db1-TCC.conf
$SHOW_SQL=true

select 't.id IS NOT NULL'::text as filtro,
	   '@$Multiop{ (t.id,e.codespecificacao) > (@tiposervico,@codespecificacao) }' as partida;
 
#source = db1-TCC.conf
$REPEAT_WHILE_FOUND=true

$SHOW_SQL=true

select
t.id as tiposervico,
t.descricao as descricao_servico,
e.codespecificacao as codespecificacao,
e.descricao as descricao_especificacao
from dof_tiposolicitacao t
join dof_especificacaoservico e on t.id = e.codsolicitacao


where @filtro::native
      @query=db1-TCC.conf{select ' and ('||condicaopartida||')' from bi.relatorio_carga
                    where tipo = 3 and escopo = @filtro order by id desc limit 1 }::native

order by t.id,e.codespecificacao
limit 1

#if found = 1
repeat;

#if not found  
stop;

#target = db1-TCC.conf
$BATCH_SIZE=10
$SHOW_SQL=true
$LABEL=INSERT @#rowid: t.id=@tiposervico, e.codespecificacao=@codespecificacao


insert into bi.tipo_servico
(
tipo_servico,descricao_servico,cod_especificacao,descricao_especificacao
) 
values
(
@tiposervico,@descricao_servico,@codespecificacao,@descricao_especificacao
) 
on conflict (tipo_servico,cod_especificacao) do nothing 

#afterlast = db1-TCC.conf
$RECURSIVE_REFERENCE=true
insert into bi.relatorio_carga(tipo, escopo, updatedregistro, registros, condicaopartida,proc_id)
values (3, @filtro, now(), @#rowid, @partida, @proc_id);