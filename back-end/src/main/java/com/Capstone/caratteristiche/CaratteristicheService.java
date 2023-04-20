package com.Capstone.caratteristiche;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




import jakarta.persistence.EntityNotFoundException;

@Service
public class CaratteristicheService {

	@Autowired CaratteristicheRepository repo;
	
	public Caratteristiche createCaratteristiche(Caratteristiche p) {

	repo.save(p);
	System.out.println("caratteristiche  creato");
		return p;
	}
	
	public List<Caratteristiche> getAllCaratteristiche() {
		return (List<Caratteristiche>) repo.findAll();
	}
	
	public Caratteristiche getCaratteristicheById(Long id) {
		if(!repo.existsById(id)) {
			 throw new EntityNotFoundException("questa Caratteristiche non esiste");
		}
		return repo.findById(id).get();
	}
	
	public Caratteristiche updateCaratteristiche(Caratteristiche p) {
		if(!repo.existsById(p.getId())) {
			 throw new EntityNotFoundException("questa Caratteristiche non esiste");
		}
		repo.save(p);
		return p;
	}
	
	public String removeCaratteristiche(Long id) {
		if(!repo.existsById(id)) {
			 throw new EntityNotFoundException("questa Caratteristiche non esiste");
		}
		repo.deleteById(id);
		return "Caratteristiche eliminato";
	}
	
	
}
