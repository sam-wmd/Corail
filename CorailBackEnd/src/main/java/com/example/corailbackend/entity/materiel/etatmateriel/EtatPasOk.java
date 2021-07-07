package com.example.corailbackend.entity.materiel.etatmateriel;

import javax.persistence.Entity;

@Entity
public abstract class EtatPasOk extends EtatMateriel {

	@Override
	public boolean canBeReserved() {
		return false;
	}

}
