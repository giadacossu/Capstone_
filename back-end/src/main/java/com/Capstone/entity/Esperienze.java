package com.Capstone.entity;




import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.Data;
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table
@Data
public abstract class Esperienze {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
	private String nome;
	private String descrizione;
	private String citta;

}
