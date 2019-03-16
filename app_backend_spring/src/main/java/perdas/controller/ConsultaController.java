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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import perdas.model.Bairro;
import perdas.model.FatoDimensoes;
import perdas.model.Organizacao;
import perdas.model.Tempo;
import perdas.service.Consulta;

@RestController
@RequestMapping("/consulta")
@CrossOrigin
public class ConsultaController {
	
	@Autowired
	private Consulta service;
	
	@GetMapping(value="/setor", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String,List<Organizacao>> ctlOrg(){
        HashMap<String,List<Organizacao>> entities = new HashMap<String,List<Organizacao>>(); 
        entities.put("setor", service.ctOrganizacao());
		/*return new ResponseEntity<List<Organizacao>>(
				entities,
				(entities.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK)
			);*/
        return entities;
	}
/*	public ResponseEntity<List<Fato>> listagemAnalises() {
		List<Fato> lListaAnalise = service.getAll();
		return new ResponseEntity<List<Fato>>(
			lListaAnalise,
			(lListaAnalise.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK)
		);
	}
	*/
	
	@GetMapping(value="/tempoOr", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Tempo> ctTmp(){
        List<Tempo> entities = service.ctTempo();
		/*return new ResponseEntity<List<Tempo>>(
				entities,
				(entities.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK)
			);*/
        return entities;
	}
	
	@GetMapping(value="/tempo", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, List<Tempo>> ctlTmp(){
        HashMap<String,List<Tempo>> entities = new HashMap<String,List<Tempo>>();
        		entities.put("meses",service.ctTempo());
//        ResponseEntity<List<Bairro>> rs = new ResponseEntity<List<Bairro>>(
//				entities,
//				(entities.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK)
//			);
		return entities
			;
	}
	
	@GetMapping(value="/bairro", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, List<Bairro>> ctlEnd(){
        HashMap<String,List<Bairro>> entities = new HashMap<String,List<Bairro>>();
        		entities.put("bairros",service.ctEndereco());
//        ResponseEntity<List<Bairro>> rs = new ResponseEntity<List<Bairro>>(
//				entities,
//				(entities.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK)
//			);
		return entities
			;
	}

	@GetMapping(value="/fatodim", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FatoDimensoes>> ctlFatoDim(){
        List<FatoDimensoes> entities = service.FatoDim();
		return new ResponseEntity<List<FatoDimensoes>>(
				entities,
				(entities.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK)
			);
	}


}
