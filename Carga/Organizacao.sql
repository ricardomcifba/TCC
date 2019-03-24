#macro = 4200-ORGANIZACAO
$SHOW_SCENE=false
$SHOW_STATUS=false

#source = db1-TCC.conf
select random(999999999) as proc_id


#source = db1-TCC.conf
$SHOW_SQL=true
select 'regiao IS NOT NULL'::text as filtro,
	   '@$Multiop{ (regiao,unidade,localidade,setor) > (@regiao,@unidade,@localidade,@setor) }' as partida;
 
#source = db1-TCC.conf
$REPEAT_WHILE_FOUND=true

$SHOW_SQL=true
select
r.id as regiao,
r.nome as sigla_r,
ur.id as unidade,
ur.sigla as sigla_ur,
l.id as localidade,
l.nome as nome_loc,
s.setor
from dof_localidade l
join dof_setor s on s.localidade = l.id
join dof_unidaderegional ur on ur.id = l.unidade
join dof_regiao r on ur.regiao = r.id

where @filtro::native
      @query=db1-TCC.conf{select ' and ('||condicaopartida||')' from bi.relatorio_carga
                    where tipo = 1 and escopo = @filtro order by id desc limit 1 }::native

order by regiao,unidade,localidade,setor
limit 1

#if found = 1
repeat;

#if not found  
stop;

#target = db1-TCC.conf
$BATCH_SIZE=10
$SHOW_SQL=true
$LABEL=INSERT @#rowid: regiao=@regiao, unudade = @unidade, localidade = @localidade, setor = @setor


insert into bi.unidade_organizacional
(
    empresa,sigla_empresa,regiao,nome_regiao,unidade,nome_unidade,localidade,nome_localidade,setor
) 
values
(
5,'EMBASA',@regiao,@sigla_r,@unidade,@sigla_ur,@localidade,@nome_loc,@setor
) on conflict (regiao,unidade,localidade,setor) do nothing 

#afterlast = db1-TCC.conf
$RECURSIVE_REFERENCE=true
insert into bi.relatorio_carga(tipo, escopo, updatedregistro, registros, condicaopartida, proc_id)
values (1, @filtro, now(), @#rowid, @partida, @proc_id);