package perdas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import perdas.dao.FatoDAO;
import perdas.model.Fato;

@Service
public class Analise {
	
	@Autowired
	private FatoDAO dao;
	
	
	public List<Fato> getAll() {
		return dao.findAll();
	}

}
