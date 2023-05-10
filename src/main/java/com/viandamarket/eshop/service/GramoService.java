package com.viandamarket.eshop.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viandamarket.eshop.model.Gramo;


@Service
public class GramoService {

	private final ArrayList<Gramo> lista = new ArrayList<>();

	@Autowired
	public GramoService() {
		lista.add(new Gramo(350, 1, 1));
		lista.add(new Gramo(440, 1, 2));
		lista.add(new Gramo(700, 1, 3));
		lista.add(new Gramo(550, 1, 4));
		lista.add(new Gramo(850, 1, 5));
	}// constructor

	public ArrayList<Gramo> getAllGramos() {
		return lista;
	}//getAllCortes

	public Gramo getGramo(Long id) {
		Gramo tmGramo = null;
		for (Gramo gramo : lista) {
			if (gramo.getId() == id) {
				tmGramo = gramo;
			}//if
		}//for
		return tmGramo;
	}//getGramo

	public Gramo deleteGramo(Long id) {
		Gramo tmGramo = null;
		for (Gramo gramo : lista) {
			if (gramo.getId() == id) {
				tmGramo = lista.remove(lista.indexOf(gramo));
				break;
			}//if
		}//for
		return tmGramo;
	}//deleteGramo

	public Gramo addGramo(Gramo gramo) {
		lista.add(gramo);
		return gramo;
	}//addGramo
	
	public Gramo updateGramo (Long id, Double Gramos, Long idcortes, Long idcomplementos) {
		Gramo tmGramo=null;
		for (Gramo gramo : lista) {
			if (gramo.getId()==id) {
				if (Gramos!=null)  gramo.setGramos(Gramos);
				if (idcortes!=null)  gramo.setIdcortes(idcortes);
				if (idcomplementos!=null)  gramo.setIdcomplementos(idcomplementos);
				tmGramo =  gramo;
				break;
			}
		}
		return tmGramo;
	}
	

}//class GramoService
