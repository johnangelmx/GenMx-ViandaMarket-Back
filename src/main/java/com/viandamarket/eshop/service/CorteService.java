package com.viandamarket.eshop.service;

import java.util.List;

import com.viandamarket.eshop.model.Corte;

import com.viandamarket.eshop.repository.CorteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CorteService {
    private final CorteRepository corteRepository;

    @Autowired
    public CorteService(CorteRepository corteRepository) {
        this.corteRepository = corteRepository;
    }


    public List<Corte> getAllCortes() {
        // TODO Auto-generated method stub
        return corteRepository.findAll();
    }

    public Corte getCorte(Long id) {
        return corteRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("El Corte " + id + " No Exite"));
    }

    public Corte deleteCorte(Long id) {
        Corte tmpUser = null;
        if (corteRepository.existsById(id)) {
            tmpUser = corteRepository.findById(id).get();
            corteRepository.deleteById(id);
        }
        return tmpUser;
    }

    public Corte addCorte(Corte corte) {
        return corteRepository.save(corte);
    }

    public Corte updateCorte(long id, String nombre, Double precio, String descripcion_corte, Boolean disponibilidad, Float cantidad_disponible, Long idcalidades, String imagen) {
        Corte tmpCorte = null;
        if (corteRepository.existsById(id)) {
            tmpCorte = corteRepository.findById(id).get();
            if (nombre != null) tmpCorte.setNombre(nombre);
            if (precio != null) tmpCorte.setPrecio(precio);
            if (descripcion_corte != null) tmpCorte.setDescripcion_corte(descripcion_corte);
            if (disponibilidad != null) tmpCorte.setDisponibilidad(disponibilidad);
            if (cantidad_disponible != null) tmpCorte.setCantidad_disponible(cantidad_disponible);
            if (idcalidades != null) tmpCorte.setIdcalidades(idcalidades);
            if (imagen != null) tmpCorte.setImagen(imagen);
            corteRepository.save(tmpCorte);
        } else {
            System.out.println("update - El corte con id " + id + " no existe");
        }
        return tmpCorte;
    }

}
