package com.example.corailbackend.entity.group;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.example.corailbackend.entity.AbstractEntity;
import com.example.corailbackend.entity.user.User;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Groupe extends AbstractEntity {

	private String nom;

	@OneToMany
	public Set<User> users;
}
