package com.example.corailbackend.entity.user;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

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
	@OneToMany
	private Set<Role> roles;

	public User() {

	}

	public User(String name, String lastname, String username, String email, String password, Set<Role> roles) {
		this.name = name;
		this.lastname = lastname;
		this.username = username;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}

	public User(String name, String lastname, String username, String email, String password) {
		this.name = name;
		this.lastname = lastname;
		this.username = username;
		this.email = email;
		this.password = password;
	}

}
