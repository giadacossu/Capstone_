package com.Capstone.piatti;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;



import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;


@Service
public class PiattiTipiciService {
	
	static  List<PiattiTipici> piattiGalluresi = new ArrayList<PiattiTipici>();
	static List <PiattiTipici> piattiSassaresi= new ArrayList<PiattiTipici>();
	
	
	@Autowired PiattiTipiciRepository repo;
	
	public PiattiTipici createPiatti(PiattiTipici p) {
		if(repo.existsByNome(p.getNome())) {
			 throw new EntityExistsException(" piatto  già presente!");
		}
	repo.save(p);
	System.out.println(p.getNome()+" creato");
		return p;
	}
	
	public List<PiattiTipici> getAllPiatti(/*int p, int dim*/) {
		return  repo.findAll(/*PageRequest.of(p, dim*/);
	}
	
	public PiattiTipici getPiattiById(Long id) {
		if(!repo.existsById(id)) {
			 throw new EntityNotFoundException("questo piatto non esiste");
		}
		return repo.findById(id).get();
	}
	
	public Page<PiattiTipici> getPiattiByNome(String nome, int pagina, int dimensioniPagina) {
		return repo.findByNome(nome,PageRequest.of(pagina, dimensioniPagina));
	}
	public Page<PiattiTipici> getPiattiByCitta(String citta,  int pagina, int dimensioniPagina) {
		return repo.findByCitta(citta,PageRequest.of(pagina, dimensioniPagina));
	}
	
	public Page<PiattiTipici> getPiattiByProvenienza(Provenienza provenienza ,  int pagina, int dimensioniPagina) {
		return repo.findByProvenienza(provenienza,PageRequest.of(pagina, dimensioniPagina));
	}
	public List<PiattiTipici> getPiattiTipiciByUtente(String nome) {
		return repo.findByUtente(nome);
	}
	
	public PiattiTipici updatePiatti(PiattiTipici p) {
		if(!repo.existsById(p.getId())) {
			 throw new EntityNotFoundException("questo piatto non esiste");
		}
		repo.save(p);
		return p;
	}
	
	public String removePiatto(Long id) {
		if(!repo.existsById(id)) {
			 throw new EntityNotFoundException("questo piatto non esiste");
		}
		repo.deleteById(id);
		return "piatto eliminato";
	}
	
	
}
