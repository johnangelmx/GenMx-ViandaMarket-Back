package com.viandamarket.eshop.controller;

import java.util.List;

import com.viandamarket.eshop.model.Corte;
import com.viandamarket.eshop.service.CorteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//CRUD Create - Read - Update - Delete
//HTTP POST   - GET  - PUT    - DELETE
//API Rest
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/cortes/")
public class CorteController {
    private final CorteService corteService;

    @Autowired
    public CorteController(CorteService corteService) {
        this.corteService = corteService;
    }

    //-- GETs -Read
    // Gets para todos
    @GetMapping
    public List<Corte> getAllCortes() {
        return corteService.getAllCortes();
    }

    // Gets para uno en especifico
    @GetMapping(path = "{corteId}")
    public Corte getCorte(@PathVariable("corteId") Long id) {
        return corteService.getCorte(id);

    }

    //-- DELETE - Delete
    // Delete para uno en especifico
    @DeleteMapping(path = "{corteId}")
    public Corte deleteCorte(@PathVariable("corteId") Long id) {
        return corteService.deleteCorte(id);

    }

    //-- Posts - Create
    // Post para crear un elemento en especifico
    @PostMapping
    public Corte addCorte(@RequestBody Corte cortes) {
        return corteService.addCorte(cortes);

    }

    //-- Put - Update
    // Put para crear un elemento en especifico
    @PutMapping(path = "{corteId}")
    public Corte addCorte(@PathVariable("corteId") long id, 
    		@RequestParam(required = false) String nombre, 
    		@RequestParam(required = false) Double precio, 
    		@RequestParam(required = false) String descripcion_corte, 
    		@RequestParam(required = false) Boolean disponibilidad, 
    		@RequestParam(required = false) Float cantidad_disponible, 
    		@RequestParam(required = false) Long idcalidades,
    		@RequestParam(required = false) String imagen){
        return corteService.updateCorte(id, nombre, precio, descripcion_corte, disponibilidad, cantidad_disponible, idcalidades, imagen);
    }


}
