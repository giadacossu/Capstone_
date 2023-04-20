package com.Capstone.spiaggia;

import java.util.ArrayList;
import java.util.List;

import com.Capstone.entity.Esperienze;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="spiagge")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Spiaggia extends Esperienze {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		private String nome;
		private String citta;
		private String url;
		private String percorso;
		private String descrizione;
		private boolean accesibileDisabili;
		private boolean tipicamenteAffollata;
        private List <String> attivita = new ArrayList <String>();
        private String utente;
        public List<String> addAttivita(String a){
        	attivita.add(a);
			return attivita;
        	
        }

}
