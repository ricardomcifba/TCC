package perdas.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import perdas.model.Bairro;
import perdas.model.FatoDimensoes;
import perdas.model.Organizacao;
import perdas.model.Tempo;

@Service
public class Consulta {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Organizacao> ctOrganizacao() {
		
		String sqlOrg =
				"select setor, count(*) total, "+
				"round(sum(perda_agua)::numeric,2)::double precision perdaA, "+
				"round(sum(perda_financeira)::numeric,2)::double precision perdaF " +
				"from fato f "+
				"join dimensao_organizacional o on f.id_organizacao = o.id_organizacao "+
				"group by setor "+
				"order by setor ";
		
	    return jdbcTemplate.query(sqlOrg, new RowMapper<Organizacao>() {

			@Override
			public Organizacao mapRow(ResultSet rs, int rowNum) throws SQLException {
				Organizacao resultado = new Organizacao(rs.getInt("setor"),rs.getInt("total"),rs.getDouble("perdaA"),rs.getDouble("perdaF"));
				
				return resultado;
			}
	    	
	    });
	}
	
	public List<Bairro> ctEndereco() {
		
		String sqlEnd =
				"select nome_bairro, count(*) total, "+ 
				"round(sum(perda_agua)::numeric,2)::double precision perdaA, "+
				"round(sum(perda_financeira)::numeric,2)::double precision perdaF " +
				"from fato f "+
				"join dimensao_endereco t on t.id_endereco = f.id_endereco "+
				"group by nome_bairro "+
				"order by nome_bairro ";
	
	    return jdbcTemplate.query(sqlEnd, new RowMapper<Bairro>() {

			@Override
			public Bairro mapRow(ResultSet rs, int rowNum) throws SQLException {
				Bairro resultado = new Bairro(rs.getString("nome_bairro"),rs.getInt("total"),rs.getDouble("perdaA"),rs.getDouble("perdaF"));

				return resultado;
				
			}	    	
	    });
	}
	
	public List<Tempo> ctTempo() {
		
		String sqlTempo =
				"select mes, nome_mes, count(*) total, "+ 
				"round(sum(perda_agua)::numeric,2)::double precision perdaA, "+
				"round(sum(perda_financeira)::numeric,2)::double precision perdaF " +
				"from fato f "+
				"join dimensao_tempo t on t.id_tempo = f.id_tempo "+
				"group by mes,nome_mes "+
				"order by mes";
	
	
	    return jdbcTemplate.query(sqlTempo, new RowMapper<Tempo>() {

			@Override
			public Tempo mapRow(ResultSet rs, int rowNum) throws SQLException {
				Tempo resultado = new Tempo(rs.getInt("mes"),rs.getString("nome_mes"),rs.getInt("total"),rs.getDouble("perdaA"),rs.getDouble("perdaF"));

				return resultado;
				
			}	    	
	    });
	}
	
	public List<FatoDimensoes> FatoDim(){
		String sqlFatoDim =
				"select f.id_fato,f.total,f.perda_agua,f.perda_financeira,o.*,e.id_endereco,e.uf,e.nome_municipio,e.nome_bairro,e.nome_logradouro, s.*,t.* from bi.tabela_fato  f\r\n" + 
				"join bi.unidade_organizacional o on f.id_organizacao = o.id_organizacao\r\n" + 
				"join bi.endereco_solicitacao e on f.id_endereco = e.id_endereco\r\n" + 
				"join bi.tipo_servico s on f.id_servico = s.id_servico\r\n" + 
				"join bi.tempo t on f.id_tempo = t.id_tempo\r\n" + 
				"order by mes,data_dia";
	
		 return jdbcTemplate.query(sqlFatoDim, new RowMapper<FatoDimensoes>() {

				@Override
				public FatoDimensoes mapRow(ResultSet rs, int rowNum) throws SQLException {
					FatoDimensoes resultado = new FatoDimensoes(rs.getInt("id_fato"),rs.getInt("total"),rs.getDouble("perda_agua"),rs.getDouble("perda_financeira"),
																rs.getInt("id_organizacao"),rs.getInt("empresa"),rs.getString("sigla_empresa"),rs.getInt("regiao"),
																rs.getString("nome_regiao"),rs.getInt("unidade"),rs.getString("nome_unidade"),rs.getInt("localidade"),
																rs.getString("nome_localidade"),rs.getInt("setor"),rs.getInt("id_endereco"),rs.getString("uf"),rs.getString("nome_municipio"),
																rs.getString("nome_bairro"),rs.getString("nome_logradouro"),rs.getInt("id_servico"),rs.getInt("tipo_servico"),
																rs.getString("descricao_servico"),rs.getInt("cod_especificacao"),rs.getString("descricao_especificacao"),rs.getInt("id_tempo"),
																rs.getDate("data_dia"),rs.getInt("ano"),rs.getInt("mes"),rs.getString("nome_mes"),rs.getInt("dia"),rs.getInt("dia_do_ano"),
																rs.getString("dia_da_semana"),rs.getString("quarto"),rs.getString("ano_quarto"),rs.getString("ano_mes_ref"),
																rs.getDate("inicio_semana"),rs.getDate("final_semana"),rs.getDate("inicio_mes"),rs.getDate("final_mes"));

					return resultado;
					
				}	    	
		    });
		}
	
	
	
	
//Para retornar qualuqer tipo de informação independente de possuir classes criadas.
//Interessante para selects na base utilizando joins, agregações e afins	
/*	public List<Object[]> ctTempo(Object ... param) { 
		
		Mesmo exemplo da consulta acima ignorando a necessidade de criar uma classe para representa-la
		String sqlTempo =
				"select mes, nome_mes count(*) total, "+ 
				"round(sum(perda_agua)::numeric,2)::double precision perdaA, "+
				"round(sum(perda_financeira)::numeric,2)::double precision perdaF " +
				"from fato f "+
				"join dimensao_endereco t on t.id_endereco = f.id_endereco "+
				"group by nome_bairro "+
				"order by nome_bairro";
	
	
	    return jdbcTemplate.query(sqlTempo, new RowMapper<Object[]>() {

			@Override
			public Object[] mapRow(ResultSet rs, int rowNum) throws SQLException {
				Object[] resultado = new Object[5];
				resultado[0] = rs.getInt("mes");
				resultado[1] = rs.getString("nome_mes");
				resultado[2] = rs.getInt("total");
				resultado[3] = rs.getDouble("perdaA");
				resultado[4] = rs.getDouble("perdaF");
				return resultado;
				
			}	    	
	    });
	}
*/		


}
