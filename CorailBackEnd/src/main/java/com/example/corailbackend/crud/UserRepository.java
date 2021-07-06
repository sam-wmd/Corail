package com.example.corailbackend.crud;

import com.example.corailbackend.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
