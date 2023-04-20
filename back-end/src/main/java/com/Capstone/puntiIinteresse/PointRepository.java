package com.Capstone.puntiIinteresse;



import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.CrudRepository;







public interface PointRepository  extends CrudRepository<Point, Long> {
	public boolean existsByNome(String nome);
	public Page <Point> findByCitta (String citta, PageRequest p);
	public Page<Point> findByNome(String nome, PageRequest p);
	public List<Point> findByUtente(String utente) ;
}
