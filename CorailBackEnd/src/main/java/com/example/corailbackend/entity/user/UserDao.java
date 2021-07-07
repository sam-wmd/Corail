package com.example.corailbackend.entity.user;

import java.util.Set;

public class UserDao extends User {

	User user;

	public UserDao(User user) {
		this.user = user;
	}

	@Override
	public int getId() {
		return user.getId();
	}

	@Override
	public String getLastname() {
		return user.getLastname();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public String getName() {
		return user.getName();
	}

	@Override
	public String getEmail() {
		return user.getEmail();
	}

	@Override
	public String getPassword() {
		return "[mdp]";
	}

	@Override
	public Set<Role> getRoles() {
		return user.getRoles();
	}

}
