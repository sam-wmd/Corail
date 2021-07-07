package com.example.corailbackend.controller;

import com.example.corailbackend.entity.projet.etat_projet.EtatProjet;
import com.example.corailbackend.entity.projet.Projet;
import com.example.corailbackend.repository.EtatProjetRepository;
import com.example.corailbackend.repository.ProjetRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RequestMapping("/api/v0/projets")
@RestController
@NoArgsConstructor
public class ProjetController {

    @Autowired
    private ProjetRepository projetRepository;

    @Autowired
    private EtatProjetRepository etatProjetRepository;


    @GetMapping("ping")
    public String getPing() {
        return "Ping ---- Hello from ProjetController -------";
    }


    @GetMapping()
    public ResponseEntity<List<Projet>> getAllProjets() {
        List<Projet> liste = (List<Projet>) this.projetRepository.findAll();
        return ResponseEntity.ok(liste);
    }

    @GetMapping("/{projetId}")
    public ResponseEntity<Projet> getProjetById(@PathVariable(value = "projetId") int projetId) {
        Projet projet = projetRepository.getById(projetId);
        return ResponseEntity.ok(projet);
    }

    /**
     *
     * @param req
     * @return ARRAY OF JSON Objects
     *
     * Exemple Request :
     * {
     *     "nom" : "Projet Robots",
     *     "description" : "RIL 2004",
     *     "temps" : "3",
     *     "etatProjetId" : "10"
     * }
     */
    @PostMapping()
    public ResponseEntity<List<Projet>> postProjet(@RequestBody Map<String,String> req) {
        Projet newProjet = new Projet();

        newProjet.setNom(req.get("nom"));
        newProjet.setDescription(req.get("description"));
        newProjet.setTemps(Integer.parseInt(req.get("temps")));

        int etatId = Integer.parseInt(req.get("etatProjetId"));
        EtatProjet etatProjet = etatProjetRepository.getById(etatId);

        newProjet.setEtatProjet(etatProjet);

        projetRepository.save(newProjet);
        return this.getAllProjets();
    }


    /**
     *
     * @param projetId
     * @param req
     * @return
     * @throws ResourceNotFoundException if Projet not found
     *
     * Example request
     *
     * {
     *     "nom" : "First Project Test",
     *     "description" : "Updated description",
     *     "temps" : "2",
     *     "etatProjet" : "BLOQUE"
     * }
     */
    @PutMapping("/{projetId}")
    public ResponseEntity<Projet> modifyProjet(@PathVariable(value = "projetId") int projetId,
                                                   @RequestBody Map<String,String> req) throws ResourceNotFoundException {
        Projet projet = projetRepository.getById(projetId);


        if (req.containsKey("nom")) projet.setNom(req.get("nom"));

        if (req.containsKey("description")) projet.setDescription(req.get("description"));


        if (req.containsKey("temps")){
            int temps = Integer.parseInt(req.get("temps"));
            projet.setTemps(temps);
        }
        if (req.containsKey("etatProjetId")){
            int etatId = Integer.parseInt(req.get("etatProjetId"));
            EtatProjet etatProjet = etatProjetRepository.getById(etatId);

            projet.setEtatProjet(etatProjet);
        }

        final Projet updatedProjet = projetRepository.save(projet);

        return ResponseEntity.ok(updatedProjet);
    }

    @DeleteMapping("/{projetId}")
    public ResponseEntity<String> deleteProjet(@PathVariable("projetId") int projetId) throws ResourceNotFoundException {
        Projet projet = projetRepository.getById(projetId);

        projetRepository.delete(projet);
        return ResponseEntity.ok("DELETE SUCCESS");
    }

}
