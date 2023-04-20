package com.Capstone.puntiIinteresse;

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
@RequestMapping("/point")
@CrossOrigin(origins = "http://localhost:4200/")
public class PointController {
	
 @Autowired PointService service;
 
	@GetMapping
	public ResponseEntity<List<Point>> getAllPoint(){
		return new ResponseEntity<List<Point>>(service.getAllPoint(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Point> getPointById(@PathVariable Long id){
		return new ResponseEntity <Point>(service.getPointById(id),HttpStatus.OK);
		
	}
	@GetMapping("/citta/{citta}")
	public ResponseEntity<Page<Point>> getPointByCitta(@PathVariable String citta,@RequestParam(value = "pagina",  defaultValue = "0") int pagina,@RequestParam(value = "dim", defaultValue = "4") int dimensioniPagina){
		return  ResponseEntity.ok(service.getPointByCitta(citta, pagina,dimensioniPagina ));
		
	}
	@GetMapping("/nome/{nome}")
	public ResponseEntity<Page<Point>> getPointByNome(@PathVariable String nome,@RequestParam(value = "pagina",  defaultValue = "0") int pagina,@RequestParam(value = "dim", defaultValue = "4") int dimensioniPagina){
		return  ResponseEntity.ok(service.getPointByCitta(nome, pagina,dimensioniPagina ));
		
	}
	@GetMapping("/utente/{u}")
	public ResponseEntity<List<Point>> getCittaByUtente(@PathVariable String u){
		return  ResponseEntity.ok(service.getPointByUtente(u));
		
	}
	@PostMapping
	public ResponseEntity <Point> createPoint(@RequestBody Point p){
		return new ResponseEntity <Point>(service.createPoint(p), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity <Point> updatePoint(@RequestBody Point p){
		return new ResponseEntity <Point>(service.updatePoint(p),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity <String> deletePoint(@PathVariable Long id){
		return new ResponseEntity<String>(service.removePoint(id),HttpStatus.OK);
		
	}
}
