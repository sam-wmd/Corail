package com.example.corailbackend.entity.user;

import com.example.corailbackend.entity.AbstractEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import java.util.Optional;
import java.util.Set;

@Data
@Entity
public class Role extends AbstractEntity {

    @Enumerated(EnumType.STRING)
    private Roles libelle;

    @ManyToMany
    private Set<User> users;
}

enum Roles {
    ADMIN,
    USER
}
