package com.example.corailbackend.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="PROJET")
public class Projet extends AbstractEntity{
    private String nom;
    private String description;
    private int temps;

    @OneToOne
    private EtatProjet etatProjet;
}
