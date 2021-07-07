package com.example.corailbackend.repository;

import com.example.corailbackend.entity.materiel.Materiel;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

public interface MaterielRepository extends AbstractEntityRepository<Materiel> {

    default Materiel getById(int id) {
        Materiel materiel = this.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Matériel non trouvé avec l'id " + id + " !"));
        return materiel;
    }
}
