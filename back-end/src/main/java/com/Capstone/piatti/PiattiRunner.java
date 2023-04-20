package com.Capstone.piatti;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class PiattiRunner implements ApplicationRunner {
	@Autowired
	PiattiTipiciService service;

	@Override
	public void run(ApplicationArguments args) throws Exception {

	//	creaListaSS();
		//creaListaAl();
	}
	public List<PiattiTipici>creaListaAl() {
		List<PiattiTipici> piatti = new ArrayList<PiattiTipici>();
		piatti.add(creaPiatto());
		
		return piatti;

	}
	public List<PiattiTipici>creaListaSS() {
		List<PiattiTipici> piatti = new ArrayList<PiattiTipici>();
		piatti.add(creaPiatto());
		
		return piatti;

	}
	
	public List<PiattiTipici>creaLista() {
		List<PiattiTipici> piatti = new ArrayList<PiattiTipici>();
		piatti.add(creaPiatto());
		
		return piatti;

	}

	public PiattiTipici creaPiatto() {

		PiattiTipici b = new PiattiTipici();
		b.setNome("Crema catalana");
		b.setCitta("Alghero");
		b.setProvenienza(Provenienza.SASSARESE);
		b.setDescrizione("col tempo, la città di Alghero si è talmente specializzata, da poterne costituire un vanto, quasi definendola crema sarda alla catalana");
	//	b.setUrl("https://www.gustosesapores.com/wp-content/uploads/2014/10/formaggelle.jpg");

	//	service.createPiatti(b);

		return b;

	}

}
