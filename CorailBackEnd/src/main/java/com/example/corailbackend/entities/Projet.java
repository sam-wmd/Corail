package com.example.corailbackend.entities;

import com.example.corailbackend.enums.EtatProjetEnum;
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
public class Projet {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    private String nom;
    private String description;
    private int temps;

    @Enumerated(EnumType.STRING)
    private EtatProjetEnum etatProjet;
}
