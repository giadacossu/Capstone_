package com.Capstone.caratteristiche;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


import com.Capstone.piatti.PiattiRunner;
import com.Capstone.puntiIinteresse.PointRunner;
import com.Capstone.spiaggia.SpiaggeRunner;

@Component
public class CaratteristicheRunner implements ApplicationRunner {
	@Autowired
	CaratteristicheService service;
	@Autowired
	PiattiRunner runP;
	@Autowired
	PointRunner runPoint;
	@Autowired
	SpiaggeRunner runS;


	@Override
	public void run(ApplicationArguments args) throws Exception {

		
		//creaCaratteristiche();
	}

	public Caratteristiche creaCaratteristiche() {
		Caratteristiche c = new Caratteristiche();
		c.addPiatti(runP.creaListaAl());
		c.addPoint(runPoint.createListaAl());
		c.addSpiaggia(runS.creaListaAl());
		
	//service.createCaratteristiche(c);
		
	
		return c;
	}
}
