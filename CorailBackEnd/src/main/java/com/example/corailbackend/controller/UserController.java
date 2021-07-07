package com.example.corailbackend.controller;

import com.example.corailbackend.repository.UserRepository;
import com.example.corailbackend.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/")
    public String createUser(@RequestBody User user) {
        userRepository.save(user);
        return "{ \"status\": \"Ok\" }";
    }

    @GetMapping("/")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable int id) {
        return userRepository.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public String removeUser(@PathVariable int id) {
        userRepository.deleteById(id);
        return "{ \"status\": \"Ok\" }";
    }
}
