package perdas.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import perdas.dao.FatoDAO;
import perdas.model.Fato;
//import perdas.model.Organizacao;
import perdas.service.Analise;
@RestController
@RequestMapping("/analise")
//No 'Access-Control-Allow-Origin' header is present on the requested resource.
@CrossOrigin
public class FatoController {

	@Autowired
	private Analise service;
	@Autowired
	private FatoDAO dao;

	/**
	 * Método responsável pela gerência de requisições GET.
	 * 
	 * 
	 * @return, lista de analise já realizada pelo sistema e seus resultados;
	 */
	
	@GetMapping(value="/listagem", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Fato>> listagemAnalises() {
		List<Fato> lListaAnalise = service.getAll();
		return new ResponseEntity<List<Fato>>(
			lListaAnalise,
			(lListaAnalise.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK)
		);
	}
	
	@GetMapping(value="/listpage", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> listaPage(Pageable page) {
		
		System.err.println(page.getPageNumber());
		System.err.println(page.getPageSize());

		return new ResponseEntity<>(
			 dao.findAll(page),  HttpStatus.OK)
		;
	}
	
	@GetMapping(value="/listagem1", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String,List<Fato>> listagem1() {
		HashMap<String,List<Fato>> entities = new HashMap<String,List<Fato>>(); 
		entities.put("fato", service.getAll());

		return entities;
	}
	
	/**
	 * 
	 * 	 MÃ©todo responsÃ¡vel pela gerencia de requisiÃ§Ãµes POST.
	 * 
	 * @param pResultado, atributo que contÃ©m a string a ser analisado.
	 * @return, json com o resultado da analise lÃ©xica.
	 */
/*	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Resultado> processarAnaliseString(
			@RequestBody @Valid Resultado pResultado
		) {
		return new ResponseEntity<Resultado>(
				service.processarAnaliseLexica(pResultado),
				HttpStatus.OK
			);
	}
*/
}
