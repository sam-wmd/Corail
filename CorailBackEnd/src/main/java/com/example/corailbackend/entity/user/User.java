package com.example.corailbackend.entity.user;

import javax.persistence.Entity;

import com.example.corailbackend.entity.AbstractEntity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

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

	@Getter @Setter
	private String password;

	@Getter @Setter
	private Role role;

	public User() {

	}

	public User(String name, String lastname, String username, String email, String password, Role role) {
		this.name = name;
		this.lastname = lastname;
		this.username = username;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public User(String name, String lastname, String username, String email, String password) {
		this.name = name;
		this.lastname = lastname;
		this.username = username;
		this.email = email;
		this.password = password;
	}

}
