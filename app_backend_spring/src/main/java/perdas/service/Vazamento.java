package perdas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import perdas.dao.RelVazamentoDAO;
import perdas.model.RegistroVazamento;

@Service
public class Vazamento {

	@Autowired
	private RelVazamentoDAO dao;

	public List<RegistroVazamento> getAll() {
		return dao.findAll();
	}


}
