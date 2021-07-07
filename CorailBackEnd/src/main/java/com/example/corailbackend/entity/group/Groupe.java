package com.example.corailbackend.entity.group;

import com.example.corailbackend.entity.AbstractEntity;
import com.example.corailbackend.entity.user.User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Generated;

import javax.persistence.*;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Groupe extends AbstractEntity {

    private String nom;

    @OneToMany
    public Set<User> users;
}
