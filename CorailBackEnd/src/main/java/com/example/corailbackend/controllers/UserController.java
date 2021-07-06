package com.example.corailbackend.controllers;

import com.example.corailbackend.crud.UserRepository;
import com.example.corailbackend.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
