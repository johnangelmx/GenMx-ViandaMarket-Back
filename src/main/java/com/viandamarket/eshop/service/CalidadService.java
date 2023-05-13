package com.viandamarket.eshop.service;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.viandamarket.eshop.model.Calidad;



@Service
public class CalidadService {

	public final ArrayList<Calidad> lista = new ArrayList<>();
	@Autowired
	public CalidadService(){
	//	public Calidad(String marca, String pais, String descripcion_marca, String calidad)	
	
		lista.add(new Calidad("A5","Japon","Carne roja de importacion","Prime"));
		lista.add(new Calidad("A5","Japon","Carne roja de importacion","Prime"));
		lista.add(new Calidad("A5","Japon","Carne roja de importacion","Prime"));
		lista.add(new Calidad("A5","Japon","Carne roja de importacion","Prime"));
		
	}//constructor
	
	
	public ArrayList<Calidad> getAllCalidades(){
		return lista;
	
	}//getAllcalidades

	public Calidad getCalidad(Long id) {
		Calidad tmpProd = null;
		for(Calidad calidad:lista) {
			if (calidad.getId()==id) {
				return calidad;
			}//if
		}//foreach
		return tmpProd;
	}//getProducto
	
	
	public Calidad deleteCalidad(Long id) {
		Calidad tmpProd = null;
		for(Calidad calidad:lista) {
			if (calidad.getId()==id) {
				tmpProd = lista.remove(lista.indexOf(calidad));
				break;
			}//if
		}//foreach
		return tmpProd;
	}//getProducto
	
	public Calidad addCalidad (Calidad calidad) {
		lista.add(calidad);
		return calidad;
	}//addProducto
	
	public Calidad updateCalidad(long id, String marca, String pais, 
			String descripcion_marca, String calidad) {
		Calidad tmCali=null;
		for (Calidad calid : lista) {
			if (calid.getId()==id) {
				if (marca!=null)  calid.setMarca(marca);
				if (pais!=null)  calid.setPais(pais);
				if (descripcion_marca!=null)  calid.setDescripcion_marca(descripcion_marca);
				if (calidad!=null)  calid.setCalidad(calidad);
				tmCali =  calid;
				break;
			}
		}
		return tmCali;
	}//updateUsuario
	
	
	
}//class CalidadService
