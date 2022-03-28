package com.eDev.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Developper")
public class Developper {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name="code")
	private Programmeur programmeur;
	
	@ManyToOne
	@JoinColumn(name="reference")
	private Projet projet;
	
	private Integer heures;
	
	
	
	public Developper() {
		
	}

	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Programmeur getProfesseur() {
		return programmeur;
	}

	public void setProfesseur(Programmeur programmeur) {
		this.programmeur = programmeur;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public Integer getHeures() {
		return heures;
	}

	public void setHeures(Integer heures) {
		this.heures = heures;
	}
	

}
