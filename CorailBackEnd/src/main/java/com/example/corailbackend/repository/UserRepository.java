package com.example.corailbackend.repository;

import com.example.corailbackend.entity.user.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.Column;
import java.util.Set;

public interface UserRepository extends AbstractEntityRepository<User> {

    @Query("select u.lastname, u.name, u.email, u.username, u.roles from User as u where u.id = ?1")
    User getUserById(@Param("id") int id);
}
