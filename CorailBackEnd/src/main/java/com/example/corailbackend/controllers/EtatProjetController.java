package com.example.corailbackend.controllers;

import com.example.corailbackend.entities.EtatProjet;
import com.example.corailbackend.entities.Projet;
import com.example.corailbackend.enums.EtatProjetEnum;
import com.example.corailbackend.repo.EtatProjetRepository;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.EnumUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RequestMapping("/api/v0/etats_projets")
@RestController
@NoArgsConstructor
public class EtatProjetController {

    @Autowired
    private EtatProjetRepository etatProjetRepository;

    @GetMapping("ping")
    public String getPing() {
        return "Ping ---- Hello from EtatProjet Controller -------";
    }


    @GetMapping()
    public ResponseEntity<List<EtatProjet>> getAllEtatProjets() {
        List<EtatProjet> liste = (List<EtatProjet>) this.etatProjetRepository.findAll();
        return ResponseEntity.ok(liste);
    }

    @GetMapping("/{etatProjetId}")
    public ResponseEntity<EtatProjet> getEtatById(@PathVariable(value = "etatProjetId") int etatProjetId) {
        EtatProjet etatProjet = etatProjetRepository.getById(etatProjetId);

        return ResponseEntity.ok(etatProjet);
    }

    /**
     *
     * @param req
     * @return
     * @throws IllegalArgumentException if libelle not in EtatProjetEnum (LIBELLE INVALIDE)
     *
     * Example Request
     * {
     *     "libelle" : "PLANIFIE"
     * }
     */
    @PostMapping()
    public ResponseEntity<EtatProjet> postEtatProjet(@RequestBody Map<String,String> req) throws IllegalArgumentException{
        if (EnumUtils.isValidEnum(EtatProjetEnum.class, req.get("libelle"))){
            EtatProjet etat = new EtatProjet();
            etat.setEtatProjetLibelle(req.get("libelle"));
            final EtatProjet newEtat = etatProjetRepository.save(etat);
            return ResponseEntity.ok(newEtat);
        }
        throw new IllegalArgumentException("LIBELLE INVALIDE");
    }

    /**
     *
     * @param etatProjetId
     * @param req
     * @return
     * @throws ResourceNotFoundException if ETAT_PROJET not found
     * {
     *     "libelle" : "EN_COURS"
     * }
     */
    @PutMapping("/{etatProjetId}")
    public ResponseEntity<EtatProjet> modifyEtatProjet(@PathVariable(value = "etatProjetId") int etatProjetId,
                                                   @RequestBody Map<String,String> req) throws ResourceNotFoundException {
        EtatProjet etatProjet = etatProjetRepository.getById(etatProjetId);

        etatProjet.setEtatProjetLibelle(req.get("libelle"));
        final EtatProjet updatedEtat = etatProjetRepository.save(etatProjet);

        return ResponseEntity.ok(updatedEtat);
    }

    @DeleteMapping("/{etatProjetId}")
    public ResponseEntity<String> deleteEtatProjet(@PathVariable("etatProjetId") int etatProjetId) throws ResourceNotFoundException {
        EtatProjet etatProjet = etatProjetRepository.getById(etatProjetId);

        etatProjetRepository.delete(etatProjet);
        return ResponseEntity.ok("DELETE SUCCESS");
    }

}
