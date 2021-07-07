package com.example.corailbackend.repository;

import com.example.corailbackend.entity.session.Session;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.UUID;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface SessionRepository extends CrudRepository<Session, Integer> {

//  In case it is decided that sessionId should be UUID
    @Query("select s.id, s.debut, s.fin, s.projet from Session as s where s.id = ?1")
    Session getSessionByUUID(@Param("id") UUID uuid);


    default Session getById(int sessionId) {

        Session session = this.findById(sessionId)
                .orElseThrow(() -> new ResourceNotFoundException("Session non trouvée avec l'id " + sessionId + " !"));
        return session;
    }
}
