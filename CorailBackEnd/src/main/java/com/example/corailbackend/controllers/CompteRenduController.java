package com.example.corailbackend.controllers;

import com.example.corailbackend.entities.CompteRendu;
import com.example.corailbackend.repo.CompteRenduRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/api/v0/compte_rendu")
@RestController
@NoArgsConstructor
@AllArgsConstructor
public class CompteRenduController {

    @Autowired
    private CompteRenduRepository compteRenduRepository;

    @GetMapping("ping")
    public String getPing() {
        return "Ping ---- Hello from CompteRenduController -------";
    }


    @GetMapping()
    public ResponseEntity<List<CompteRendu>> getAllCompteRendus() {
        List<CompteRendu> liste = (List<CompteRendu>) this.compteRenduRepository.findAll();
        return ResponseEntity.ok(liste);
    }

    @PostMapping()
    public ResponseEntity<List<CompteRendu>> postCompteRendu(@RequestBody CompteRendu compteRendu) {
        compteRenduRepository.save(compteRendu);
        return this.getAllCompteRendus();
    }

    @PutMapping("/{compteRenduId}")
    public ResponseEntity<CompteRendu> modifyCompteRendu(@PathVariable(value = "compteRenduId") int compteRenduId,
                                                   @RequestBody CompteRendu modifiedCompteRendu) throws ResourceNotFoundException {
        CompteRendu compteRendu = compteRenduRepository.findById(compteRenduId)
                .orElseThrow(() -> new ResourceNotFoundException("Compte Rendu non trouvé avec l'id " + compteRenduId + " !"));


        compteRendu.setTitre(modifiedCompteRendu.getTitre());
        compteRendu.setContenu(modifiedCompteRendu.getContenu());
        final CompteRendu updatedCompteRendu = compteRenduRepository.save(compteRendu);

        return ResponseEntity.ok(updatedCompteRendu);
    }

    @DeleteMapping("/{compteRenduId}")
    public String deleteCompteRendu(@PathVariable("compteRenduId") int compteRenduId) throws ResourceNotFoundException{
        CompteRendu compteRendu = compteRenduRepository.findById(compteRenduId)
                .orElseThrow(() -> new ResourceNotFoundException("Compte Rendu non trouvée avec l'id " + compteRenduId + " !"));

        compteRenduRepository.delete(compteRendu);
        return "Compte Rendu" + compteRendu.toString() + "deleted: " + Boolean.TRUE;
    }

}
