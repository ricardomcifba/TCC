package perdas.controller;

import java.util.List;

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
	
	@GetMapping(value="/organizacao", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Organizacao>> ctlOrg(){
        List<Organizacao> entities = service.ctOrganizacao();
		return new ResponseEntity<List<Organizacao>>(
				entities,
				(entities.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK)
			);
	}
/*	public ResponseEntity<List<Fato>> listagemAnalises() {
		List<Fato> lListaAnalise = service.getAll();
		return new ResponseEntity<List<Fato>>(
			lListaAnalise,
			(lListaAnalise.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK)
		);
	}
	*/
	
	@GetMapping(value="/tempo", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Tempo>> ctTmp(){
        List<Tempo> entities = service.ctTempo();
		return new ResponseEntity<List<Tempo>>(
				entities,
				(entities.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK)
			);
	}
	
	@GetMapping(value="/bairro", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Bairro>> ctlEnd(){
        List<Bairro> entities = service.ctEndereco();
		return new ResponseEntity<List<Bairro>>(
				entities,
				(entities.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK)
			);
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
