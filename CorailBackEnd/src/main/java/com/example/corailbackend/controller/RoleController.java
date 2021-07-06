package com.example.corailbackend.controller;

import com.example.corailbackend.entity.user.Role;
import com.example.corailbackend.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;


    @GetMapping("/")
    public List<Role> getRoles() {
        return roleRepository.findAll();
    }
}
