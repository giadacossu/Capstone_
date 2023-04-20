package com.Capstone.citta;

import com.Capstone.caratteristiche.Caratteristiche;
import com.Capstone.entity.Luogo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Citta")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Citta extends Luogo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String url;
	private String provincia;
	private String utente;
	
	@OneToOne(cascade = CascadeType.ALL)
	Caratteristiche caratteristiche;
	
	
	
}
