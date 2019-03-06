package perdas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import perdas.dao.DimensaoOrganizacionalDAO;
import perdas.model.UnidadeOrganizacional;

@Service
public class Organizacao {
	
	@Autowired
	private DimensaoOrganizacionalDAO dao;
	
	public List<UnidadeOrganizacional> getAll() {
		return dao.findAll();
	}

}
