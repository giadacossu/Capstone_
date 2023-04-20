package com.Capstone.caratteristiche;

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
@RequestMapping("/caratteristiche")
@CrossOrigin(origins = "http://localhost:4200/")
public class CaratteristicheController {

	
	@Autowired CaratteristicheService service;
	
	@GetMapping
	public ResponseEntity<List<Caratteristiche>> getAllCaratteristiche(){
		return new ResponseEntity<List<Caratteristiche>>(service.getAllCaratteristiche(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Caratteristiche> getCaratteristicheById(@PathVariable Long id){
		return new ResponseEntity <Caratteristiche>(service.getCaratteristicheById(id),HttpStatus.OK);
		
	}
	
	@PostMapping
	public ResponseEntity <Caratteristiche> createPiatti(@RequestBody Caratteristiche p){
		return new ResponseEntity <Caratteristiche>(service.createCaratteristiche(p), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity <Caratteristiche> updateCaratteristiche(@RequestBody Caratteristiche p){
		return new ResponseEntity <Caratteristiche>(service.updateCaratteristiche(p),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity <String> deleteCaratteristiche(@PathVariable Long id){
		return new ResponseEntity<String>(service.removeCaratteristiche(id),HttpStatus.OK);
		
	}
}
