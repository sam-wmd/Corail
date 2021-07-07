package com.example.corailbackend.entity.user;

import com.example.corailbackend.entity.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
public class User extends AbstractEntity {

    @Getter @Setter
    private String name;

    @Getter @Setter
    private String lastname;

    @Getter @Setter
    private String username;

    @Getter @Setter
    private String email;

    @Setter
    private String password;

    @Getter @Setter
    @OneToMany
    private Set<Role> roles;
}
