package com.example.corailbackend.controllers;

import com.example.corailbackend.entities.CompteRendu;
import com.example.corailbackend.entities.Session;
import com.example.corailbackend.repo.CompteRenduRepository;
import com.example.corailbackend.repo.SessionRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RequestMapping("/api/v0/comptes_rendus")
@RestController
@NoArgsConstructor
@AllArgsConstructor
public class CompteRenduController {

    @Autowired
    private CompteRenduRepository compteRenduRepository;

    @Autowired
    private SessionRepository sessionRepository;

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
    public ResponseEntity<List<CompteRendu>> postCompteRendu(@RequestBody Map<String, String> req) {
        CompteRendu newCompteRendu = new CompteRendu();

        newCompteRendu.setTitre(req.get("titre"));
        newCompteRendu.setContenu(req.get("contenu"));

//      find and set Session
        int sessionId = Integer.parseInt(req.get("sessionId"));

        Session session = sessionRepository.getById(sessionId);

        newCompteRendu.setSession(session);

        compteRenduRepository.save(newCompteRendu);
        return this.getAllCompteRendus();
    }

    @PutMapping("/{compteRenduId}")
    public ResponseEntity<CompteRendu> modifyCompteRendu(@PathVariable(value = "compteRenduId") int compteRenduId,
                                                         @RequestBody Map<String, String> req) throws ResourceNotFoundException {
        CompteRendu compteRendu = compteRenduRepository.getById(compteRenduId);


        if (req.containsKey("titre"))  compteRendu.setTitre(req.get("titre"));
        if (req.containsKey("contenu"))  compteRendu.setContenu(req.get("contenu"));
        final CompteRendu updatedCompteRendu = compteRenduRepository.save(compteRendu);

        return ResponseEntity.ok(updatedCompteRendu);
    }

    @DeleteMapping("/{compteRenduId}")
    public ResponseEntity<String> deleteCompteRendu(@PathVariable("compteRenduId") int compteRenduId) throws ResourceNotFoundException {
        CompteRendu compteRendu = compteRenduRepository.getById(compteRenduId);

        compteRenduRepository.delete(compteRendu);
        return ResponseEntity.ok("DELETE SUCCESS");
    }

}
