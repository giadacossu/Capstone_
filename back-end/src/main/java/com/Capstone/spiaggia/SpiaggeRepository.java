package com.Capstone.spiaggia;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.CrudRepository;





public interface SpiaggeRepository extends CrudRepository<Spiaggia, Long>{
	public boolean existsByNome(String nome);
	public Page<Spiaggia> findByNome(String nome, PageRequest p);
	public Page<Spiaggia> findByCitta (String citta,PageRequest p);
	public List<Spiaggia> findByUtente(String utente) ;

}
