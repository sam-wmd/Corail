package com.example.corailbackend.entity.materiel;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import com.example.corailbackend.entity.AbstractEntity;
import com.example.corailbackend.entity.Reservable;
import com.example.corailbackend.entity.materiel.etatmateriel.EtatMateriel;
import com.example.corailbackend.entity.session.Session;
import com.example.corailbackend.exception.CannotReserveException;
import com.example.corailbackend.exception.LibelleVideException;

import lombok.Data;

@Data
@Entity
public class Materiel extends AbstractEntity implements Reservable {

	String libelle;

	@OneToOne
	EtatMateriel etat;

	public Materiel() {

	}

	public Materiel(String libelle) throws LibelleVideException {
		if(libelle == null || libelle.isEmpty()) {
			throw new LibelleVideException();
		}
		this.libelle = libelle;
	}

	public Materiel(String libelle, EtatMateriel etat) throws LibelleVideException {
		if(libelle == null || libelle.isEmpty()) {
			throw new LibelleVideException();
		}
		this.libelle = libelle;
		this.etat = etat;
	}

	@Override
	public void reserver(Session session) throws CannotReserveException {
		if(!etat.canBeReserved()) {
			throw new CannotReserveException();
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Materiel other = (Materiel) obj;
		if (!Objects.equals(etat, other.etat)) {
			return false;
		}
		return Objects.equals(libelle, other.libelle);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (etat == null ? 0 : etat.hashCode());
		result = prime * result + (libelle == null ? 0 : libelle.hashCode());
		return result;
	}

	public void setLibelle(String libelle) throws LibelleVideException {
		if(libelle == null || libelle.isEmpty()) {
			throw new LibelleVideException();
		}
		this.libelle = libelle;
	}

}
