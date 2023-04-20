package com.Capstone.puntiIinteresse;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class PointRunner implements ApplicationRunner {

	@Autowired
	PointService service;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// createLista();
		// createListaPT();
		// createListaSS();
//	createListaAl();
		// System.out.println(service.getPointByCitta("olbia"));

	}

	public List<Point> createListaAl() {
		List<Point> lista = new ArrayList<Point>();

		lista.add(createPoint());
		return lista;
	}

	public List<Point> createListaSS() {
		List<Point> lista = new ArrayList<Point>();

		lista.add(createPoint());
		return lista;
	}

	public List<Point> createListaPT() {
		List<Point> listaT = new ArrayList<Point>();

		listaT.add(createPoint());
		return listaT;
	}

	public List<Point> createLista() {
		List<Point> lista = new ArrayList<Point>();

		lista.add(createPoint());
		return lista;
	}

	public Point createPoint() {

		Point p = new Point();
		p.setNome("Rovine Romane di Sant'Imbenia");
		p.setCitta("alghero");
		p.setDescrizione(
				"Le Rovine Romane di Sant'Imbenia costituiscono un sito archeologico situato a ridosso del Parco di Porto Conte. Si tratta di un antico complesso nuragico ci si arriva mediante una stradina che costeggia il mare.");
		p.setPercorso("Strada Provinciale 55, 07041 Alghero SS");
		p.setOrario("aperto 09:00-16:36");
		p.setPagamento(true);

		// service.createPoint(p);

		return p;
	}
}
