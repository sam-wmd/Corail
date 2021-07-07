package com.example.corailbackend.repository;

import com.example.corailbackend.entity.compte_rendu.CompteRendu;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface CompteRenduRepository extends CrudRepository<CompteRendu, Integer> {

    default CompteRendu getById(int id) {
        CompteRendu compteRendu = this.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Compte Rendu non trouvé avec l'id " + id + " !"));
        return compteRendu;
    }
}
