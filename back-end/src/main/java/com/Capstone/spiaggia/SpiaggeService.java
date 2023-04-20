package com.Capstone.spiaggia;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;



import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class SpiaggeService {

	@Autowired SpiaggeRepository repo;
	
	public Spiaggia createSpiaggia(Spiaggia p) {
		if(repo.existsByNome(p.getNome())) {
			 throw new EntityExistsException(" Spiaggia  già presente!");
		}
	repo.save(p);
	System.out.println(p.getNome()+" creato");
		return p;
	}
	
	public List<Spiaggia> getAllSpiaggia() {
		return (List<Spiaggia>) repo.findAll();
	}
	
	public Spiaggia getSpiaggiaById(Long id) {
		if(!repo.existsById(id)) {
			 throw new EntityNotFoundException("questa Spiaggia non esiste");
		}
		return repo.findById(id).get();
	}
	
	public Page<Spiaggia> getPiattiByNome(String nome,int pagina, int dimensioniPagina) {
		return repo.findByNome(nome,  PageRequest.of (pagina, dimensioniPagina));
	}
	
	public Page<Spiaggia> getPointByCitta(String citta,int pagina, int dimensioniPagina) {
		return repo.findByCitta(citta,  PageRequest.of (pagina, dimensioniPagina));
	}
	public List<Spiaggia> getSpiaggiaByUtente(String nome) {
		return repo.findByUtente(nome);
	}
	
	public Spiaggia updateSpiaggia(Spiaggia p) {
		if(!repo.existsById(p.getId())) {
			 throw new EntityNotFoundException("questa Spiaggia non esiste");
		}
		repo.save(p);
		return p;
	}
	
	public String removeSpiaggia(Long id) {
		if(!repo.existsById(id)) {
			 throw new EntityNotFoundException("questo Spiaggia non esiste");
		}
		repo.deleteById(id);
		return "Spiaggia eliminato";
	}
}
