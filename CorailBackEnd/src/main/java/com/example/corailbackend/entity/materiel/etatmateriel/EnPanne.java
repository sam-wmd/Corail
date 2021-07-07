package com.example.corailbackend.entity.materiel.etatmateriel;

import javax.persistence.Entity;

@Entity
public class EnPanne extends EtatPasOk {

	@Override
	public String getLibelle() {
		return "En panne";
	}

}
