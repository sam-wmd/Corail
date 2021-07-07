package com.example.corailbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.corailbackend.entity.group.Groupe;
import com.example.corailbackend.repository.GroupeRepository;

@RestController
@RequestMapping("/groups")
public class GroupController {

	@Autowired
	private GroupeRepository groupeRepository;

	@PostMapping("/")
	public String createGroup(@RequestBody Groupe groupe) {
		groupeRepository.save(groupe);
		return "{ \"status\": \"Ok\" }";
	}

	@GetMapping("/{id}")
	public Groupe getGroup(@PathVariable int id) {
		return groupeRepository.getById(id);
	}

	@DeleteMapping("/{id}")
	public String removeGroup(@PathVariable int id) {
		groupeRepository.deleteById(id);
		return "{ \"status\": \"Ok\" }";
	}
}
