package com.example.corailbackend.entity.user;

import com.example.corailbackend.entity.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class User extends AbstractEntity {

    private String name;

    private String lastname;

    private String username;

    private String email;

    private String password;

    @OneToMany
    private Set<Role> roles;
}
