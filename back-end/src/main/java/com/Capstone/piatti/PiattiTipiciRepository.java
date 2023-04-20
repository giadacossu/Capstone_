package com.Capstone.piatti;



import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;




public interface PiattiTipiciRepository  extends JpaRepository<PiattiTipici, Long>{
	public boolean existsByNome(String nome);
	
	public Page<PiattiTipici> findByNome(String nome, PageRequest p);
	public Page<PiattiTipici> findByCitta (String citta, PageRequest p);
	public Page<PiattiTipici> findByProvenienza(Provenienza provenienza, PageRequest p);
	public List<PiattiTipici> findByUtente(String utente) ;
	


}
