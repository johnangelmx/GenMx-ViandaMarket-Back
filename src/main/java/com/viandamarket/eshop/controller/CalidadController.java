package com.viandamarket.eshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.viandamarket.eshop.model.Calidad;
import com.viandamarket.eshop.service.CalidadService;


//CRUD Create - Read - Update - Delete
//HTTP POST   - GET  - PUT    - DELETE
//API Rest
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/calidad/")
public class CalidadController {
    private final CalidadService calidadService;

    @Autowired
    public CalidadController(CalidadService calidadService) {
        this.calidadService = calidadService;
    }//-- GETs -Read
    // Gets para todos


    @GetMapping
    public List<Calidad> getAllCalidades() {
        return calidadService.getAllCalidades();
    }//GetMappping

    // Gets para uno en especifico
    @GetMapping(path = "{calidadId}")
    public Calidad getCalidad(@PathVariable("calidadId") Long id) {
        return calidadService.getCalidad(id);
    }// GetMapping

    //-- DELETE - Delete
    // Delete para uno en especifico
    @DeleteMapping(path = "{calidadId}")
    public Calidad deleteCalidad(@PathVariable("calidadId") Long id) {
        return calidadService.deleteCalidad(id);
    }//Delete


    //-- Posts - Create
    // Post para crear un elemento en especifico
    @PostMapping
    public Calidad addCalidad(@RequestBody Calidad calidad) {
        return calidadService.addCalidad(calidad);

    }

    //-- Put - Update
    // Put para editar un elemento en especifico
    @PutMapping(path = "{calidadId}")
    public Calidad addCalidad(@PathVariable("calidadId") long id,
                              @RequestParam(required = false) String marca,
                              @RequestParam(required = false) String pais,
                              @RequestParam(required = false) String descripcion_marca,
                              @RequestParam(required = false) String calidad) {
        return calidadService.updateCalidad(id, marca, pais, descripcion_marca, calidad);
    }


}//class

