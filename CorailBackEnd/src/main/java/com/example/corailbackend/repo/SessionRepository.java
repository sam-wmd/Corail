package com.example.corailbackend.repo;

import com.example.corailbackend.entities.Session;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface SessionRepository extends CrudRepository<Session, Integer> {

}
