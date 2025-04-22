package com.semana6.facturas.controller;

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

import com.semana6.facturas.model.Servicio;
import java.util.List;
import java.util.Optional;

import com.semana6.facturas.service.ServicioService;

@RestController
@RequestMapping("/servicios")
@CrossOrigin(origins = "*")
public class ServicioController {
    @Autowired
    private ServicioService servicioService;

    @GetMapping
    public List<Servicio> getAllServicio(){
        return servicioService.getAllServicios();

    }

    @GetMapping("/{id}")
    public Optional<Servicio> getServicioById(@PathVariable Long id){
        return servicioService.getServicioById(id);
    }

    //nuevos controller para el CRUD

    @PostMapping
    public Servicio createServicio(@RequestBody Servicio servicio){
        return servicioService.createServicio(servicio);
    }

    @PutMapping("/{id}")
    public Servicio updateServicio(@PathVariable Long id, @RequestBody Servicio servicio){
        return servicioService.updateServicio(id, servicio);
    }

    @DeleteMapping("{id}")
    public void deleteServicio(@PathVariable Long id){
        servicioService.deleteServicio(id);
    }
    
}