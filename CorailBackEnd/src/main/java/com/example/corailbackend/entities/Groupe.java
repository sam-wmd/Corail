package com.example.corailbackend.entities;

import lombok.Data;
import lombok.Generated;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Groupe {

    @Id
    @Generated
    private Long id;
}
