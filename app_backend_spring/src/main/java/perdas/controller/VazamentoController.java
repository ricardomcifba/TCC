package perdas.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import perdas.model.RegistroVazamento;
import perdas.service.Vazamento;
@RestController
@RequestMapping("/vazamento")
//No 'Access-Control-Allow-Origin' header is present on the requested resource.
@CrossOrigin
public class VazamentoController {

	@Autowired
	private Vazamento service;

	/**
	 * Método responsável pela gerência de requisições GET.
	 * 
	 * 
	 * @return, lista de analise já realizada pelo sistema e seus resultados;
	 */
	
	@GetMapping(value="/listvaz", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<RegistroVazamento>> listagemVazamentos() {
		List<RegistroVazamento> lListaVaz = service.getAll();
		return new ResponseEntity<List<RegistroVazamento>>(
				lListaVaz,
			(lListaVaz.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK)
		);
	}
	
	@GetMapping(value="/listmap", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, List<RegistroVazamento>> listagemMap(){
        HashMap<String,List<RegistroVazamento>> entities = new HashMap<String,List<RegistroVazamento>>();
        		entities.put("registros",service.getAll());

		return entities			;
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
