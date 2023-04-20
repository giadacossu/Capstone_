package com.Capstone.citta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;



import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class CittaService {
 
	@Autowired CittaRepository repo;
	
	public Citta createCitta(Citta p) {
		if(repo.existsByNome(p.getNome())) {
			 throw new EntityExistsException(" Citta  già presente!");
		}
	repo.save(p);
	System.out.println(p.getNome()+" creato");
		return p;
	}
	
	public List<Citta> getAllCitta() {
		return (List<Citta>) repo.findAll();
	}
	
	public Citta getCittaById(Long id) {
		if(!repo.existsById(id)) {
			 throw new EntityNotFoundException("questa Citta non esiste");
		}
		return repo.findById(id).get();
	}
	public Citta getCittaByNome(String nome) {
		return repo.findByNome(nome);
	}
	public List<Citta> getCittaByUtente(String nome) {
		return repo.findByUtente(nome);
	}
	public Citta updateCitta(Citta p) {
		if(!repo.existsById(p.getId())) {
			 throw new EntityNotFoundException("questa Citta non esiste");
		}
		repo.save(p);
		return p;
	}
	
	public String removeCitta(Long id) {
		if(!repo.existsById(id)) {
			 throw new EntityNotFoundException("questa Citta non esiste");
		}
		repo.deleteById(id);
		return "Citta eliminato";
	}
	
}
