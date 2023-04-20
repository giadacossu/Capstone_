package com.Capstone.piatti;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/piattiTipici")
@CrossOrigin(origins = "http://localhost:4200/")
public class PiattiTiiciController {

	
	@Autowired PiattiTipiciService service;
	
	@GetMapping
	public ResponseEntity<List<PiattiTipici>> getAllPiatti(/*@RequestParam(value= "pagina", defaultValue = "20")int p, @RequestParam(value= "dim", defaultValue = "20")int dim*/){
		return new ResponseEntity<List<PiattiTipici>>(service.getAllPiatti(/*p, dim*/),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PiattiTipici> getPiattiById(@PathVariable Long id){
		return new ResponseEntity <PiattiTipici>(service.getPiattiById(id),HttpStatus.OK);
		
	}
	@GetMapping("/citta/{citta}")
	public ResponseEntity<Page<PiattiTipici>> getPiattiByCitta(@PathVariable String citta,@RequestParam(value = "pagina",  defaultValue = "0") int pagina,@RequestParam(value = "dim", defaultValue = "4") int dimensioniPagina){
		return  ResponseEntity.ok(service.getPiattiByCitta(citta, pagina,dimensioniPagina ));
		
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<Page<PiattiTipici>> getPointByNome(@PathVariable String nome,@RequestParam(value = "pagina",  defaultValue = "0") int pagina,@RequestParam(value = "dim", defaultValue = "4") int dimensioniPagina){
		return  ResponseEntity.ok(service.getPiattiByNome(nome, pagina,dimensioniPagina ));
		
	}
	
	@GetMapping("/provenienza/{provenienza}")
	public ResponseEntity<Page<PiattiTipici>> getPointByProvenienza(@PathVariable Provenienza provenienza,@RequestParam(value = "pagina",  defaultValue = "0") int pagina,@RequestParam(value = "dim", defaultValue = "4") int dimensioniPagina){
		return  ResponseEntity.ok(service.getPiattiByProvenienza(provenienza, pagina,dimensioniPagina ));
		
	}
	@GetMapping("/utente/{u}")
	public ResponseEntity<List<PiattiTipici>> getCittaByUtente(@PathVariable String u){
		return  ResponseEntity.ok(service.getPiattiTipiciByUtente(u));
		
	}
	@PostMapping
	public ResponseEntity <PiattiTipici> createPiatti(@RequestBody PiattiTipici p){
		return new ResponseEntity <PiattiTipici>(service.createPiatti(p), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity <PiattiTipici> updatePiatti(@RequestBody PiattiTipici p){
		return new ResponseEntity <PiattiTipici>(service.updatePiatti(p),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity <String> deletePiatti(@PathVariable Long id){
		return  new ResponseEntity<String>(service.removePiatto(id),HttpStatus.OK);
	}
}
