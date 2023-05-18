package com.viandamarket.eshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.viandamarket.eshop.model.Gramo;
import com.viandamarket.eshop.repository.GramoRepository;

@Service
public class GramoService {
    public final GramoRepository gramoRepository;

    @Autowired
    public GramoService(GramoRepository gramoRepository) {
        this.gramoRepository = gramoRepository;
    }// constructor

    public List<Gramo> getAllGramos() {
        return gramoRepository.findAll();
    }// getAllGramos

    public Gramo getGramo(Long idgramos) {
        return gramoRepository.findById(idgramos).orElseThrow(() -> new IllegalArgumentException("Los gramos con id" + idgramos + " no existen"));
    }// getGramo

    public Gramo deleteGramo(Long idgramos) {
        Gramo tmGramo = null;
        if (gramoRepository.existsById(idgramos)) {
            tmGramo = gramoRepository.findById(idgramos).get();
            gramoRepository.deleteById(idgramos);
        } // if
        return tmGramo;
    }// deleteGramo

    public Gramo addGramo(Gramo idgramos) {
        return gramoRepository.save(idgramos);
    }// addGramo

    public Gramo updateGramo(Long idgramos, Integer cantidad, Long idcortes, Long idcomplementos) {
        Gramo tmGramo = null;
        if (gramoRepository.existsById(idgramos)) {
            tmGramo = gramoRepository.findById(idgramos).get();
            if (cantidad != null) tmGramo.setCantidad(cantidad);
            if (idcortes != null) tmGramo.setIdcortes(idcortes);
            if (idcomplementos != null) tmGramo.setIdcomplementos(idcomplementos);
            gramoRepository.save(tmGramo);
        } else {
            System.out.println("Update - Los gramos con id " + idgramos + " no existen");
        }//else
        return tmGramo;
    }//updateGramo

}// class GramoService
