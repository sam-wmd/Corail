package com.example.corailbackend.controllers;

import com.example.corailbackend.entities.Projet;
import com.example.corailbackend.repo.ProjetRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/api/v0/projets")
@RestController
@NoArgsConstructor
public class ProjetController {

    @Autowired
    private ProjetRepository projetRepository;

    @GetMapping("ping")
    public String getPing() {
        return "Ping ---- Hello from ProjetController -------";
    }


    @GetMapping()
    public ResponseEntity<List<Projet>> getAllProjects() {
        List<Projet> liste = (List<Projet>) this.projetRepository.findAll();
        return ResponseEntity.ok(liste);
    }

    @PostMapping()
    public String postProject(@RequestBody Projet projet) {
        projetRepository.save(projet);
        return this.projetRepository.findAll().toString();
    }

    @PutMapping("/{projectId}")
    public ResponseEntity<Projet> modifyEtatProjet(@PathVariable(value = "projectId") int projectId,
                                                   @RequestBody Projet modifiedProjet) throws ResourceNotFoundException {
        Projet projet = projetRepository.findById(projectId)
                .orElseThrow(() -> new ResourceNotFoundException("Projet non trouvé avec l'id " + projectId + " !"));


        projet.setNom(modifiedProjet.getNom());
        projet.setEtatProjet(modifiedProjet.getEtatProjet());
        projet.setDescription(modifiedProjet.getDescription());
        projet.setTemps(modifiedProjet.getTemps());
        final Projet updatedProjet = projetRepository.save(projet);

        return ResponseEntity.ok(updatedProjet);
    }

    @DeleteMapping("/{projectId}")
    public String deleteProject(@PathVariable("projectId") int projectId) throws ResourceNotFoundException {
        Projet projet = projetRepository.findById(projectId)
                .orElseThrow(() -> new ResourceNotFoundException("Projet non trouvé avec l'id " + projectId + " !"));

        projetRepository.delete(projet);
        return "SUCCES POUR DELETE : \n" + projet.getNom();
    }

}
