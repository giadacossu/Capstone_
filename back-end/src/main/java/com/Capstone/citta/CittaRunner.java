package com.Capstone.citta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


import com.Capstone.caratteristiche.CaratteristicheRunner;

@Component
public class CittaRunner implements ApplicationRunner {
	@Autowired
	CittaService service;
	@Autowired
	CaratteristicheRunner runC;

	@Override
	public void run(ApplicationArguments args) throws Exception {

	//	creaCitta();

	}

	public Citta creaCitta() {
		Citta c = new Citta();
		c.setNome("luogo");
		c.setProvincia("ss");
		c.setUrl("");
       // c.setCaratteristiche(runC.creaCaratteristiche());
        c.setUtente("g");
	//	service.createCitta(c);
		return c;
	}

}
