package com.example.corailbackend.entity.materiel.etatmateriel;

import javax.persistence.Entity;

@Entity
public class EnFonctionnement extends EtatOk {

	@Override
	public String getLibelle() {
		return "En fonctionnement";
	}

}
