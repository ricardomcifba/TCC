#macro = 4200-FATO
$SHOW_SCENE=false
$SHOW_STATUS=false

#source = db1-TCC.conf
select random(999999999) as proc_id


#source = db1-TCC.conf
$SHOW_SQL=false
select 'numerosolicitacao IS NOT NULL'::text as filtro,
	   '@$Multiop{ (numerosolicitacao,datadia) > (@numerosolicitacao,''@datadia::native'') }' as partida;
 
#source = db1-TCC.conf
$REPEAT_WHILE_FOUND=true

$SHOW_SQL=false
select
numerosolicitacao,
datadia,
id_organizacao,
id_endereco,
id_servico,
id_tempo,
dv.qtd_perda_dia as perda_m3,
dv.valor_perda as perda_fin
from bi.registro_vazamento dv
join bi.unidade_organizacional dorg on dv.regiao = dorg.regiao and dv.unidade_regional = dorg.unidade and dv.localidade = dorg.localidade and dv.setor = dorg.setor
join bi.endereco_solicitacao de on dv.localidade = de.localidade and dv.setor = de.setor and dv.bairro = de.bairro and dv.logradouro = de.logradouro  and de.localidade = dorg.localidade and de.setor = dorg.setor
join bi.tipo_servico ds on dv.tiposolicitacao = ds.tipo_servico and dv.codespecificacao = ds.cod_especificacao
join bi.tempo dt on dv.datadia = dt.data_dia

where @filtro::native
      @query=db1-TCC.conf{select ' and ('||condicaopartida||')' from bi.relatorio_carga
                    where tipo = 5 and escopo = @filtro order by id desc limit 1 }::native
order by numerosolicitacao,id_organizacao,id_endereco,id_servico,id_tempo
limit 1

#if found = 1
repeat;

#if not found  
stop;

#target = db1-TCC.conf
$BATCH_SIZE=2
$SHOW_SQL=false
$LABEL=INSERT @#rowid: numerosolicitacao = @numerosolicitac datadia=@datadia id_organizacao @id_organizacao,id_endereco = @id_endereco,id_servico = @id_servico,id_tempo = @id_tempo

insert into bi.tabela_fato 
(
id_organizacao,id_endereco,id_servico,id_tempo,total, perda_agua, perda_financeira 
) 
values
(
@id_organizacao, @id_endereco, @id_servico, @id_tempo, 1, @perda_m3, @perda_fin
) 
on conflict (id_organizacao,id_endereco,id_servico,id_tempo) 
do update set 
total = bi.tabela_fato.total + 1,
perda_agua = bi.tabela_fato.perda_agua+ @perda_m3,
perda_financeira =bi.tabela_fato.perda_financeira + @perda_fin;

#afterlast = db1-TCC.conf
$RECURSIVE_REFERENCE=true
insert into bi.relatorio_carga(tipo, escopo, updatedregistro, registros, condicaopartida, proc_id)
values (5, @filtro, now(), @#rowid, @partida, @proc_id);