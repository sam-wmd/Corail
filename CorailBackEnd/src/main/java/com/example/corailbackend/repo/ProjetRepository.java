package com.example.corailbackend.repo;

import com.example.corailbackend.entities.Projet;
import com.example.corailbackend.entities.Session;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface ProjetRepository extends CrudRepository<Projet, Integer> {


    default Projet getById(int projetId) {

        Projet projet = this.findById(projetId)
                .orElseThrow(() -> new ResourceNotFoundException("Projet non trouvée avec l'id " + projetId + " !"));
        return projet;
    }
}
