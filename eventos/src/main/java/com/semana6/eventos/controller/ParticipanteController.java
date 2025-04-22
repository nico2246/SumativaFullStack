package com.semana6.eventos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.semana6.eventos.model.Participante;
import java.util.List;
import java.util.Optional;

import com.semana6.eventos.service.ParticipanteService;

@RestController
@RequestMapping("/participantes")
@CrossOrigin(origins = "*")
public class ParticipanteController {
    @Autowired
    private ParticipanteService participanteService;

    @GetMapping
    public List<Participante> getAllParticipantes(){
        //System.out.println(">>> Entró al endpoint /Participantes");
        return participanteService.getAllParticipantes();

    }

    @GetMapping("/{id}")
    public Optional<Participante> getParticipanteById(@PathVariable Long id){
        return participanteService.getParticipanteById(id);
    }

    //nuevos controller para el CRUD

    @PostMapping
    public Participante createParticipante(@RequestBody Participante Participante){
        return participanteService.createParticipante(Participante);
    }

    @PutMapping("/{id}")
    public Participante updateParticipante(@PathVariable Long id, @RequestBody Participante Participante){
        return participanteService.updateParticipante(id, Participante);
    }

    @DeleteMapping("{id}")
    public void deleteParticipante(@PathVariable Long id){
        participanteService.deleteParticipante(id);
    }
    
}