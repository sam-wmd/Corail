package com.example.corailbackend.entity.materiel.etatmateriel;

import javax.persistence.Entity;

@Entity
public abstract class EtatOk extends EtatMateriel {

	@Override
	public boolean canBeReserved() {
		return true;
	}

}
