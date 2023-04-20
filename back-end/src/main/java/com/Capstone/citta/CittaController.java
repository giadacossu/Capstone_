package com.Capstone.citta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

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

import org.springframework.web.bind.annotation.RestController;





@RestController
@RequestMapping("/citta")
@CrossOrigin(origins = "http://localhost:4200/")
public class CittaController {

	
	@Autowired CittaService service;
	
	@GetMapping
	public ResponseEntity<List<Citta>> getAllCitta(){
		return new ResponseEntity<List<Citta>>(service.getAllCitta(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Citta> getCittaById(@PathVariable Long id){
		return new ResponseEntity <Citta>(service.getCittaById(id),HttpStatus.OK);	
	}
	
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<Citta> getCittaByNome(@PathVariable String nome){
		return  ResponseEntity.ok(service.getCittaByNome(nome));
		
	}
	@GetMapping("/utente/{u}")
	public ResponseEntity<List<Citta>> getCittaByUtente(@PathVariable String u){
		return  ResponseEntity.ok(service.getCittaByUtente(u));
		
	}
	
	@PostMapping
	public ResponseEntity <Citta> createPiatti(@RequestBody Citta p){
		return new ResponseEntity <Citta>(service.createCitta(p), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity <Citta> updateCitta(@RequestBody Citta p){
		return new ResponseEntity <Citta>(service.updateCitta(p),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity <String> deleteCitta(@PathVariable Long id){
		return new ResponseEntity<String>(service.removeCitta(id),HttpStatus.OK);
		
	}
}
