package com.example.corailbackend.entity.session;

import com.example.corailbackend.entity.AbstractEntity;
import com.example.corailbackend.entity.materiel.Materiel;
import com.example.corailbackend.entity.projet.Projet;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="SESSION")
public class Session extends AbstractEntity {

    private LocalDateTime debut;
    private LocalDateTime fin;

    @OneToOne
    private Projet projet;

    @OneToMany
    private List<Materiel> materielList;

}

