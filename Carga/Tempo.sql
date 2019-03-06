#macro = 4200-TEMPO
$SHOW_SCENE=false
$SHOW_STATUS=false

#source = db1-TCC.conf
select random(999999999) as proc_id


#source = db1-TCC.conf
$SHOW_SQL=true
select 'datadia IS NOT NULL'::text as filtro,
	   '@$Multiop{ (datadia) > (''@datadia::native'') }' as partida;
 
#source = db1-TCC.conf
$REPEAT_WHILE_FOUND=true

$SHOW_SQL=true
select 
datadia,
ano,
mes,
nome_mes,
dia,
dia_do_ano,
dia_da_semana,
quarto,
ano_quarto,
ano_mes_ref,
inicio_semana,
final_semana,
inicio_mes,
final_mes
 from view_dimensao_tempo 

where @filtro::native
      @query=db1-TCC.conf{select ' and ('||condicaopartida||')' from bi.relatorio_carga
                    where tipo = 4 and escopo = @filtro order by id desc limit 1 }::native

order by datadia
limit 1

#if found = 1
repeat;

#if not found  
stop;

#target = db1-TCC.conf
$BATCH_SIZE=10
$SHOW_SQL=false
$LABEL=INSERT @#rowid: data_dia = @datadia


insert into bi.tempo
(
data_dia,ano,mes,nome_mes,dia,dia_do_ano,dia_da_semana,quarto,ano_quarto,ano_mes_ref,
inicio_semana,final_semana,inicio_mes,final_mes
) 
values
(
@datadia,@ano,@mes,@nome_mes,@dia,@dia_do_ano,@dia_da_semana,@quarto,@ano_quarto,@ano_mes_ref,
@inicio_semana,@final_semana,@inicio_mes,@final_mes
) on conflict (data_dia) do nothing 

#afterlast = db1-TCC.conf
$RECURSIVE_REFERENCE=true
insert into bi.relatorio_carga (tipo, escopo, updatedregistro, registros, condicaopartida, proc_id)
values (4, @filtro, now(), @#rowid, @partida, @proc_id);