package com.example.corailbackend.entities;

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
public class Session extends AbstractEntity{

    private LocalDateTime debut;
    private LocalDateTime fin;

    @OneToOne
    private Projet projet;

    @OneToMany
    private List<Materiel> materielList;

}

