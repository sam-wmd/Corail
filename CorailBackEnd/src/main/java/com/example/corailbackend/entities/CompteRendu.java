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
@Table(name="COMPTE_RENDU")
public class CompteRendu {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    private String titre;
    private String contenu;

    @OneToOne
    private Session session;


    @Override
    public String toString() {
        return "CompteRendu{" +
                "titre:'" + titre + '\n' +
                "contenu'" + contenu + '\n' +
                '}';
    }
}
