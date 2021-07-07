package com.example.corailbackend.entity.projet.etat_projet;

import com.example.corailbackend.entity.AbstractEntity;
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
@Table(name="ETAT_PROJET")
public class EtatProjet extends AbstractEntity {
    private String etatProjetLibelle;

}
