package perdas.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import perdas.model.Bairro;
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
