package com.example.corailbackend.controller;

import com.example.corailbackend.entity.materiel.Materiel;
import com.example.corailbackend.entity.projet.Projet;
import com.example.corailbackend.entity.session.Session;
import com.example.corailbackend.repository.MaterielRepository;
import com.example.corailbackend.repository.ProjetRepository;
import com.example.corailbackend.repository.SessionRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;


@RequestMapping("/api/v0/sessions")
@RestController
@NoArgsConstructor
public class SessionController {

    @Autowired
    private ProjetRepository projetRepository;

    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private MaterielRepository materielRepository;

    @GetMapping("ping")
    public String getPing(){
        return "Ping ---- Hello from SessionController -------";
    }



    private LocalDateTime formatToLocalDateTime(String str){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
        return dateTime;
    }


    @GetMapping()
    public ResponseEntity<List<Session>> getAllSessions(){
        List<Session> liste = (List<Session>) this.sessionRepository.findAll();
        return ResponseEntity.ok(liste);
    }

    @GetMapping("/{sessionId}")
    public ResponseEntity<Session> getSessionById(@PathVariable(value = "sessionId") int sessionId) {
        Session session = sessionRepository.getById(sessionId);
        return ResponseEntity.ok(session);
    }

    /**
     *
     * @param req
     * Exemple
     * {
     *     "debut" : "2021-07-08 17:00",
     *     "fin" : "2021-07-08 18:00",
     *     "projetId" : "15"
     * }
     * @return JSON Array of all Sessions
     */
    @PostMapping()
    public ResponseEntity<List<Session>> postSession(@RequestBody Map<String,String> req){

        Session session = new Session();

        session.setDebut(formatToLocalDateTime(req.get("debut")));
        session.setFin(formatToLocalDateTime(req.get("fin")));

        int projetId = Integer.parseInt(req.get("projetId"));
        Projet projet = projetRepository.getById(projetId);

        session.setProjet(projet);
        sessionRepository.save(session);
        return this.getAllSessions();
    }

    /**
     *
     * @param req
     * @return JSON Object of updated Session
     *
     * Cannot modify Project once session is created
     * Exemple
     * {
     *     "debut" : "2021-07-08 17:00",
     *     "fin" : "2021-07-08 18:00",
     * }
     *
     */
    @PutMapping("/{sessionId}")
    public ResponseEntity<Session> modifySession(@PathVariable("sessionId") int sessionId, @RequestBody Map<String,String> req) throws ResourceNotFoundException {


        Session session = sessionRepository.getById(sessionId);

        if (req.containsKey("debut")) session.setDebut(formatToLocalDateTime(req.get("debut")));
        if (req.containsKey("fin"))  session.setFin(formatToLocalDateTime(req.get("fin")));

        final Session updatedSession = sessionRepository.save(session);

        return ResponseEntity.ok(updatedSession);

    }

    /**
     *
     * @param sessionId
     * @param req
     * @return
     * @throws ResourceNotFoundException
     *
     *
     * Exemple request
     * {
     *     "id" : "18" --> materielId
     * }
     */
    @PostMapping("/{sessionId}/materiel")
    public ResponseEntity<Session> addMaterielToSession(@PathVariable("sessionId") int sessionId, @RequestBody Map<String,String> req) throws ResourceNotFoundException {

        int materielId = Integer.parseInt(req.get("id"));
        Materiel materielToAdd = materielRepository.getById(materielId);

        Session session = sessionRepository.getById(sessionId);

        session.getMaterielList().add(materielToAdd);

        final Session updatedSession = sessionRepository.save(session);

        return ResponseEntity.ok(updatedSession);

    }

    /**
     *
     * @param sessionId
     * @param materielId
     * @return
     * @throws ResourceNotFoundException
     *
     * NO REQUEST BODY
     */
    @DeleteMapping("/{sessionId}/{materielId}")
    public ResponseEntity<Session> removeMaterielFromSession(@PathVariable("sessionId") int sessionId, @PathVariable("materielId") int materielId) throws ResourceNotFoundException {

        Materiel materielToRemove = materielRepository.getById(materielId);

        Session session = sessionRepository.getById(sessionId);

        session.getMaterielList().remove(materielToRemove);

        final Session updatedSession = sessionRepository.save(session);

        return ResponseEntity.ok(updatedSession);

    }

    /**
     *
     * @param sessionId
     * @return JSON STRING OBJECT
     * @throws ResourceNotFoundException
     *
     * NO REQUEST BODY
     */
    @DeleteMapping("/{sessionId}")
    public ResponseEntity<String> deleteSession(@PathVariable("sessionId") int sessionId) throws ResourceNotFoundException{
        Session session = sessionRepository.getById(sessionId);

        sessionRepository.delete(session);
        return ResponseEntity.ok("DELETE SUCCESS");
    }



}
