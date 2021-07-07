package com.example.corailbackend.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.corailbackend.entity.user.User;
import com.example.corailbackend.entity.user.UserDao;
import com.example.corailbackend.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping
	public List<UserDao> getUsers() {
		return userRepository.findAll().stream().map(UserDao::new).collect(Collectors.toList());
	}

	@GetMapping("/{id}")
	public User getUser(@PathVariable int id) {
		return new UserDao(userRepository.getUserById(id));
	}

	@DeleteMapping("/{id}")
	public String removeUser(@PathVariable int id) {
		userRepository.deleteById(id);
		return "{ \"status\": \"Ok\" }";
	}
}
