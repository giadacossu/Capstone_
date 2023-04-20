package com.Capstone.piatti;



import com.Capstone.entity.Esperienze;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="piatti tipici")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PiattiTipici extends Esperienze{

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
	
		private String nome;
		private String descrizione;
		@Enumerated(EnumType.STRING)
        private Provenienza provenienza;
		private String citta;
		private String  url;
		private String utente;
   
 
}
