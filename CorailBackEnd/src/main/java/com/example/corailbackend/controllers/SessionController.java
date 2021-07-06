package com.example.corailbackend.controllers;

import com.example.corailbackend.entities.Session;
import com.example.corailbackend.repo.SessionRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/api/v0/sessions")
@RestController
@NoArgsConstructor
public class SessionController {

    @Autowired
    private SessionRepository sessionRepository;

    @GetMapping("ping")
    public String getPing(){
        return "Ping ---- Hello from SessionController -------";
    }


    @GetMapping()
    public ResponseEntity<List<Session>> getAllSessions(){
        List<Session> liste = (List<Session>) this.sessionRepository.findAll();
        return ResponseEntity.ok(liste);
    }

    @PostMapping()
    public ResponseEntity<List<Session>> postSession(@RequestBody Session session){
        sessionRepository.save(session);
        return this.getAllSessions();
    }

    @PutMapping("/{sessionId}")
    public ResponseEntity<Session> modifySession(@PathVariable("sessionId") int sessionId, @RequestBody Session modifiedSession) throws ResourceNotFoundException {
        Session session = sessionRepository.findById(sessionId)
                .orElseThrow(() -> new ResourceNotFoundException("Session non trouvée avec l'id " + sessionId + " !"));

        session.setDebut(modifiedSession.getDebut());
        session.setFin(modifiedSession.getFin());
        session.setProjet(modifiedSession.getProjet());

        final Session updatedSession = sessionRepository.save(session);

        return ResponseEntity.ok(updatedSession);

    }

    @DeleteMapping("/{sessionId}")
    public String deleteSession(@PathVariable("sessionId") int sessionId) throws ResourceNotFoundException{
        Session session = sessionRepository.findById(sessionId)
                .orElseThrow(() -> new ResourceNotFoundException("Session non trouvée avec l'id " + sessionId + " !"));

        sessionRepository.delete(session);
        return "Session" + session.toString() + "deleted: " + Boolean.TRUE;
    }



}
