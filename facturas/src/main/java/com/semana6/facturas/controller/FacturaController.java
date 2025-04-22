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

import com.semana6.facturas.model.Factura;
import java.util.List;
import java.util.Optional;

import com.semana6.facturas.service.FacturaService;

@RestController
@RequestMapping("/facturas")
@CrossOrigin(origins = "*")
public class FacturaController {
    @Autowired
    private FacturaService facturaService;

    @GetMapping
    public List<Factura> getAllFacturas(){
        //System.out.println(">>> Entró al endpoint /facturas");
        return facturaService.getAllFacturas();

    }

    @GetMapping("/{id}")
    public Optional<Factura> getFacturaById(@PathVariable Long id){
        return facturaService.getFacturaById(id);
    }

    //nuevos controller para el CRUD

    @PostMapping
    public Factura createFactura(@RequestBody Factura factura){
        return facturaService.createFactura(factura);
    }

    @PutMapping("/{id}")
    public Factura updateFactura(@PathVariable Long id, @RequestBody Factura factura){
        return facturaService.updateFactura(id, factura);
    }

    @DeleteMapping("{id}")
    public void deleteFactura(@PathVariable Long id){
        facturaService.deleteFactura(id);
    }
    
}