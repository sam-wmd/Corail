package com.example.corailbackend.repository;

import com.example.corailbackend.entity.projet.Projet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface ProjetRepository extends CrudRepository<Projet, Integer> {


    default Projet getById(int projetId) {

        Projet projet = this.findById(projetId)
                .orElseThrow(() -> new ResourceNotFoundException("Projet non trouvé avec l'id " + projetId + " !"));
        return projet;
    }
}
