package com.example.corailbackend.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.corailbackend.entity.user.User;

public interface UserRepository extends AbstractEntityRepository<User> {

	@Query("select u.lastname, u.name, u.email, u.username, u.role from User as u where u.id = ?1")
	User getUserById(@Param("id") int id);

	User findByUsername(String username);
}
