package com.example.corailbackend.entity.compte_rendu;

import com.example.corailbackend.entity.AbstractEntity;
import com.example.corailbackend.entity.session.Session;
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
    public class CompteRendu extends AbstractEntity {

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
