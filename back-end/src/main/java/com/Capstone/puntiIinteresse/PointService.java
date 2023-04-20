package com.Capstone.puntiIinteresse;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;



import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class PointService {

	@Autowired PointRepository repo;
	

	public Point createPoint(Point p) {
		if(repo.existsByNome(p.getNome())) {
			 throw new EntityExistsException(" Point  già presente!");
		}
	repo.save(p);
	System.out.println(p.getNome()+" creato");
		return p;
	}
	
	public List<Point> getAllPoint() {
		return (List<Point>) repo.findAll();
	}
	
	public Point getPointById(Long id) {
		if(!repo.existsById(id)) {
			 throw new EntityNotFoundException("questo Point non esiste");
		}
		return repo.findById(id).get();
	}
	
	public Page<Point> getPointByNome(String nome, int pagina, int dimensioniPagina) {
		return repo.findByNome(nome, PageRequest.of (pagina, dimensioniPagina));
	}
	
	public Page<Point> getPointByCitta(String citta,  int pagina, int dimensioniPagina) {
		return (Page<Point>)repo.findByCitta(citta,PageRequest.of (pagina, dimensioniPagina));
	}
	public List<Point> getPointByUtente(String nome) {
		return repo.findByUtente(nome);
	}
	
	public Point updatePoint(Point p) {
		if(!repo.existsById(p.getId())) {
			 throw new EntityNotFoundException("questo Point non esiste");
		}
		repo.save(p);
		return p;
	}
	
	public String removePoint(Long id) {
		if(!repo.existsById(id)) {
			 throw new EntityNotFoundException("questo Point non esiste");
		}
		repo.deleteById(id);
		return "Point eliminato";
	}
}
