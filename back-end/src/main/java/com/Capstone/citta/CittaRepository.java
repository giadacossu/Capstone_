package com.Capstone.citta;

import java.util.List;


import org.springframework.data.repository.CrudRepository;


public interface CittaRepository  extends CrudRepository<Citta, Long>{
	public boolean existsByNome(String nome);
	public Citta findByNome(String nome);
	public List<Citta> findByUtente(String utente) ;
}
