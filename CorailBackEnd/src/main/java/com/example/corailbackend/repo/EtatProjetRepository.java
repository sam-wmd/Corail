package com.example.corailbackend.repo;

import com.example.corailbackend.entities.CompteRendu;
import com.example.corailbackend.entities.EtatProjet;
import com.example.corailbackend.entities.Projet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface EtatProjetRepository extends CrudRepository<EtatProjet, Integer> {


    default EtatProjet getById(int id) {
        EtatProjet etatProjet = this.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("EtatProjet non trouvé avec l'id " + id + " !"));
        return etatProjet;
    }
}
