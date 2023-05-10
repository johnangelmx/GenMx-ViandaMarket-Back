package com.viandamarket.eshop.service;

import java.util.ArrayList; 

import com.viandamarket.eshop.model.Corte;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CorteService {
	private final ArrayList<Corte> lista = new ArrayList<>();
	//Genera automaticamente al levantar el servidor
	//como los seeders de laravel (? 
	@Autowired
	public CorteService() {
		lista.add(new Corte("corte", 20.20, "Descripcion", true, 25, 1));
		lista.add(new Corte("corte", 20.20, "Descripcion", true, 25, 1));
		lista.add(new Corte("corte", 20.20, "Descripcion", true, 25, 1));
		lista.add(new Corte("corte", 20.20, "Descripcion", true, 25, 1));
		lista.add(new Corte("corte", 20.20, "Descripcion", true, 25, 1));
	}//constructor

	public ArrayList<Corte> getAllCortes() {
		// TODO Auto-generated method stub
		return lista;
	}

	public Corte getCorte(Long id) {
		Corte tmCorte=null;
		for (Corte usuario : lista) {
			if (usuario.getId()==id) {
				tmCorte= usuario;
				
			}
		}
		return tmCorte;
	}

	public Corte deleteCorte(Long id) {
		Corte tmCorte=null;
		for (Corte usuario : lista) {
			if (usuario.getId()==id) {
				tmCorte =  lista.remove(lista.indexOf(usuario));
				break;
			}
		}
		return tmCorte;
	}

	public Corte addCorte(Corte corte) {
		lista.add(corte);
		return corte;
	}

	public Corte updateCorte(long id, String nombre, Double precio, String descripcion_corte, Boolean disponibilidad,
            Float cantidad_disponible, Long idcalidades) {
		Corte tmCorte=null;
		for (Corte corte : lista) {
			if (corte.getId()==id) {
				if (nombre!=null)  corte.setNombre(nombre);
				if (precio!=null)  corte.setPrecio(precio.doubleValue());
				if (descripcion_corte!=null)  corte.setDescripcion_corte(descripcion_corte);
				if (disponibilidad!=null)  corte.setDisponibilidad(disponibilidad);
				if (cantidad_disponible!=null)  corte.setCantidad_disponible(cantidad_disponible);
				if (idcalidades!=null)  corte.setIdcalidades(idcalidades);
				tmCorte =  corte;
				break;
			}
		}
		return tmCorte;
	}
 
}
