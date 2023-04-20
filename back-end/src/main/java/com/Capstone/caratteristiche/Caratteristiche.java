package com.Capstone.caratteristiche;

import java.util.ArrayList;

import java.util.List;


import com.Capstone.piatti.PiattiTipici;
import com.Capstone.puntiIinteresse.Point;

import com.Capstone.spiaggia.Spiaggia;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "caratteristiche")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Caratteristiche {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String url;
	@OneToMany(cascade = CascadeType.ALL)
	private List<PiattiTipici> piatti= new ArrayList<PiattiTipici>();
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Point> point = new ArrayList<Point>();
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Spiaggia> spiagge= new ArrayList<Spiaggia>();
private String utente ;


	public List<PiattiTipici> addPiatti(List<PiattiTipici> list) {
		for (int i = 0; i < list.size(); i++) {
			piatti.addAll(list);
		}
		return piatti;
	}

	public List<Point> addPoint(List<Point> p) {
		for (int i = 0; i < p.size(); i++) {
			point.addAll( p);
		}

		return point;
	}

	public List<Spiaggia> addSpiaggia(List<Spiaggia> p) {
		for (int i = 0; i < p.size(); i++) {
			spiagge.addAll( p);
		}

		return spiagge;
	}
}
