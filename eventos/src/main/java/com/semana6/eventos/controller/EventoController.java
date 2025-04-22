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

import com.semana6.eventos.model.Evento;
import java.util.List;
import java.util.Optional;

import com.semana6.eventos.service.EventoService;

@RestController
@RequestMapping("/eventos")
@CrossOrigin(origins = "*")
public class EventoController {
    @Autowired
    private EventoService eventoService;

    @GetMapping
    public List<Evento> getAllEventos(){
        //System.out.println(">>> Entró al endpoint /Eventos");
        return eventoService.getAllEventos();

    }

    @GetMapping("/{id}")
    public Optional<Evento> getEventoById(@PathVariable Long id){
        return eventoService.getEventoById(id);
    }

    //nuevos controller para el CRUD

    @PostMapping
    public Evento createEvento(@RequestBody Evento Evento){
        return eventoService.createEvento(Evento);
    }

    @PutMapping("/{id}")
    public Evento updateEvento(@PathVariable Long id, @RequestBody Evento Evento){
        return eventoService.updateEvento(id, Evento);
    }

    @DeleteMapping("{id}")
    public void deleteEvento(@PathVariable Long id){
        eventoService.deleteEvento(id);
    }
    
}