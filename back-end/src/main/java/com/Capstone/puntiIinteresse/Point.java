package com.Capstone.puntiIinteresse;

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
@Table(name="point")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Point extends Esperienze  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
	
	
		private String nome;
		private String url;
		private String descrizione;
		
		private String percorso;
		private String utente;
		private String citta;
		private String orario;
		private boolean pagamento;
}
