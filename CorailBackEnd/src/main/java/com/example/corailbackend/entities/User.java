package com.example.corailbackend.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length = 255)
    private String name;

    @Column(length = 255)
    private String lastname;

    @Column(length = 255)
    private String username;

    @Column(length = 255)
    private String email;

    @Column(length = 255)
    private String password;
}
