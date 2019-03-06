package perdas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import perdas.model.UnidadeOrganizacional;
import perdas.service.Organizacao;

@RestController
@RequestMapping("/org")
@CrossOrigin
public class OrganizacaoController {
	
	@Autowired
	private Organizacao service;
	
	@GetMapping(value="/listorg", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UnidadeOrganizacional>> listagemOrg() {
		List<UnidadeOrganizacional > lListaOrg = service.getAll();
		return new ResponseEntity<List<UnidadeOrganizacional>>(
				lListaOrg,
			(lListaOrg.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK)
		);
	}
	

}
