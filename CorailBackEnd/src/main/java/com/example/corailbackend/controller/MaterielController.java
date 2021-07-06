package com.example.corailbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.corailbackend.entity.materiel.Materiel;
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
	public List<Materiel> getPing() {
		return materielRepository.findAll();
	}

	@PostMapping("/new")
	public Materiel create() {
		Materiel materiel = new Materiel();
		materiel.setEtat(etatMaterielRepository.findAll().get(0));
		materielRepository.save(materiel);
		return materiel;
	}

}
