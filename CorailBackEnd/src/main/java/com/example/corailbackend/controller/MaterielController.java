package com.example.corailbackend.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.corailbackend.entity.materiel.Materiel;
import com.example.corailbackend.entity.materiel.etatmateriel.EtatMateriel;
import com.example.corailbackend.exception.LibelleVideException;
import com.example.corailbackend.repository.EtatMaterielRepository;
import com.example.corailbackend.repository.MaterielRepository;

@RestController
@RequestMapping("/materiel")
public class MaterielController {

	@Autowired
	MaterielRepository materielRepository;

	@Autowired
	EtatMaterielRepository etatMaterielRepository;

	@GetMapping
	public List<Materiel> getMateriels() {
		return materielRepository.findAll();
	}

	@GetMapping(path="/{id}")
	public Materiel getMateriel(@PathVariable("id") String id) {
		Optional<Materiel> m = materielRepository.findById(Integer.parseInt(id));
		if(m.isPresent()) {
			return m.get();
		}
		return null;
	}

	@PostMapping(consumes = "application/json", produces = "application/json")
	public Materiel create(@RequestBody Map<String, String>  map) throws LibelleVideException {
		Materiel materiel = new Materiel(map.get("libelle"));

		String stringId = map.get("etat");
		EtatMateriel etat = null;
		Optional<EtatMateriel> optionalEtat = etatMaterielRepository.findById(1);
		if(optionalEtat.isPresent()) {
			etat = optionalEtat.get();
		}
		if(stringId != null) {
			int etatId = Integer.parseInt(stringId);
			Optional<EtatMateriel> optional = etatMaterielRepository.findById(etatId);
			etat = optional.isPresent() ? optional.get() : null;
		}
		materiel.setEtat(etat);
		materielRepository.save(materiel);
		return materiel;
	}

	@DeleteMapping(path = "/delete/{id}")
	public void delete(@PathVariable("id") String id) {
		int idInt = Integer.parseInt(id);
		materielRepository.deleteById(idInt);
	}

	@PutMapping(path="/{id}", consumes = "application/json", produces = "application/json")
	public Materiel update(@PathVariable("id") String id, @RequestBody Map<String, String>  map)  throws Exception {
		if(id == null) {
			throw new Exception("Aucun id donné");
		}
		int idMateriel = Integer.parseInt(id);
		Optional<Materiel> optional = materielRepository.findById(idMateriel);
		if(!optional.isPresent()) {
			throw new Exception("Aucun matériel à modifier avec cet id");
		}
		Materiel materiel = optional.get();

		if(map.get("libelle") != null) {
			materiel.setLibelle(map.get("libelle"));
		}
		String etatStringId = map.get("etat");
		if(etatStringId == null) {
			return materielRepository.save(materiel);
		}
		int etatId = Integer.parseInt(etatStringId);
		Optional<EtatMateriel> optionalEtat = etatMaterielRepository.findById(etatId);
		if(optionalEtat.isPresent()) {
			materiel.setEtat(optionalEtat.get());
		}
		return materielRepository.save(materiel);
	}

}
