package com.example.corailbackend.entity.user;

import com.example.corailbackend.entity.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class User extends AbstractEntity {

    @Column(length = 255)
    private String name;

    @Column(length = 255)
    private String lastname;

    @Column(length = 255)
    private String username;

    @Column(length = 255)
    private String email;

    @Column(length = 255)
    private String password;
}
