package com.Capstone.spiaggia;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SpiaggeRunner implements ApplicationRunner {
	@Autowired
	SpiaggeService service;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		// creaLista();
		// creaSpiaggia();
		// creaListaSaTe();
		// creaListaSS();
		// creaListaAl();
		//creaSpiaggia();
	}

	public List<Spiaggia> creaListaAl() {
		List<Spiaggia> spiaggia = new ArrayList<Spiaggia>();
		spiaggia.add(creaSpiaggia());
		return spiaggia;
	}

	public List<Spiaggia> creaListaSS() {
		List<Spiaggia> spiaggia = new ArrayList<Spiaggia>();
		spiaggia.add(creaSpiaggia());
		return spiaggia;
	}

	public List<Spiaggia> creaListaSaTe() {
		List<Spiaggia> spiagge = new ArrayList<Spiaggia>();
		spiagge.add(creaSpiaggia());
		return spiagge;
	}

	public List<Spiaggia> creaLista() {
		List<Spiaggia> spiaggia = new ArrayList<Spiaggia>();
		spiaggia.add(creaSpiaggia());
		return spiaggia;
	}

	public Spiaggia creaSpiaggia() {

		Spiaggia g = new Spiaggia();

		Spiaggia p = new Spiaggia();
		p.setNome("Cala Sambuco");
		p.setCitta("Santa Teresa");
		p.setDescrizione(
				"La spiaggia è una mezzaluna di sabbia chiara e fine. Il mare cristallino e dalle mille sfumature blu permette di ammirare il fondale ricco di ciottoli e scogli, ideali per gli amanti dello snorkeling. ");
		p.setPercorso("Dall'uscita di Santa Teresa procedere verso est in direzione Palau. Giunti in prossimità del piccolo centro, girare a sinistra per il ristorante La Piana. Da qui procedere sempre dritto, superando l'incrocio e svoltando a sinistra sullo sterrato.");
		p.addAttivita("snorkeling");
		p.addAttivita("immersioni");
		//p.addAttivita("windsurf");
		// p.addAttivita("kyte");
		// p.addAttivita("surf");
		//p.addAttivita("canoa");
		// p.addAttivita("barca a vela");
		p.setTipicamenteAffollata(false);
		p.setAccesibileDisabili(true);
		p.setUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTgj_sA1B4r7YIT_k44F5Fkc2scWGCizuLUhfQbttNWFzhxBoNXLvED6A_o1USvlT90FDQ&usqp=CAU");

		 //service.createSpiaggia(p);
		;
return p;
		
	}

}
