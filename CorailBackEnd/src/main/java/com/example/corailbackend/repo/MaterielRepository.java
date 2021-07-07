package com.example.corailbackend.repo;

import com.example.corailbackend.entities.EtatProjet;
import com.example.corailbackend.entities.Materiel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface MaterielRepository extends CrudRepository<Materiel, Integer> {

    default Materiel getById(int id) {
        Materiel materiel= this.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Materiel non trouvée avec l'id " + id + " !"));
        return materiel;
    }
}
