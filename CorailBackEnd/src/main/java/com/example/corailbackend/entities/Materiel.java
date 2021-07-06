package com.example.corailbackend.entities;


import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


// CREATION POUR PERMETTRE LA COMPILATION : A COMPLETER AVEC LA CLASSE DE RONAN
@Entity
@NoArgsConstructor
public class Materiel {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
}
