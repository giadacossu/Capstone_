package com.Capstone.spiaggia;

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

import com.Capstone.puntiIinteresse.Point;






@RestController
@RequestMapping("/spiagge")
@CrossOrigin(origins = "http://localhost:4200/")
public class SpiaggeController {

	
	@Autowired SpiaggeService service;
	
	@GetMapping
	public ResponseEntity<List<Spiaggia>> getAllSpiaggia(){
		return new ResponseEntity<List<Spiaggia>>(service.getAllSpiaggia(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Spiaggia> getPointById(@PathVariable Long id){
		return new ResponseEntity <Spiaggia>(service.getSpiaggiaById(id),HttpStatus.OK);
		
	}
	
	@GetMapping("/citta/{citta}")
	public ResponseEntity<Page<Spiaggia>> getPointByCitta(@PathVariable String citta,@RequestParam(value = "pagina",  defaultValue = "0") int pagina,@RequestParam(value = "dim", defaultValue = "4") int dimensioniPagina){
		return  ResponseEntity.ok(service.getPointByCitta(citta, pagina,dimensioniPagina ));
		
	}
	@GetMapping("/nome/{nome}")
	public ResponseEntity<Page<Spiaggia>> getPointByNome(@PathVariable String nome,@RequestParam(value = "pagina",  defaultValue = "0") int pagina,@RequestParam(value = "dim", defaultValue = "4") int dimensioniPagina){
		return  ResponseEntity.ok(service.getPointByCitta(nome, pagina,dimensioniPagina ));
		
	}
	@GetMapping("/utente/{u}")
	public ResponseEntity<List<Spiaggia>> getSpiaggiaByUtente(@PathVariable String u){
		return  ResponseEntity.ok(service.getSpiaggiaByUtente(u));
		
	}
	@PostMapping
	public ResponseEntity <Spiaggia> createSpiaggia(@RequestBody Spiaggia p){
		return new ResponseEntity <Spiaggia>(service.createSpiaggia(p), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity <Spiaggia> updateSpiaggia(@RequestBody Spiaggia p){
		return new ResponseEntity <Spiaggia>(service.updateSpiaggia(p),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity <String> deleteSpiaggia(@PathVariable Long id){
		return new ResponseEntity<String>(service.removeSpiaggia(id),HttpStatus.OK);
		
	}
}
