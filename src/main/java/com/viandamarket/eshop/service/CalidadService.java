package com.viandamarket.eshop.service;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.viandamarket.eshop.model.Calidad;
import com.viandamarket.eshop.repository.CalidadRepository;



@Service
public class CalidadService {

	public final CalidadRepository calidadRepository;
	
	@Autowired
	public CalidadService(CalidadRepository calidadRepository){
		this.calidadRepository=calidadRepository;
	}//constructor
	
	
	public List<Calidad> getAllCalidades(){
		return calidadRepository.findAll();
	}//getAllcalidades

	
	public Calidad getCalidad(Long id) {
		return calidadRepository.findById(id).orElseThrow(
				()->new IllegalArgumentException("El id de esta calidad " + id + " no existe")
				);
	}//getProducto
	
	
	public Calidad deleteCalidad(Long id) {
		Calidad tmpCalid = null;
		if(calidadRepository.existsById(id)) {
			tmpCalid = calidadRepository.findById(id).get();
			calidadRepository.deleteById(id);
			}//if	
		return tmpCalid;
	}//getProducto
	
	
	public Calidad addCalidad (Calidad calidad) {		
		return calidadRepository.save(calidad);
	}//addProducto
	
	
	public Calidad updateCalidad(long id, String marca, String pais, 
			String descripcion_marca, String calidad) {
		Calidad tmpCali=null;
		if(calidadRepository.existsById(id)) {
			tmpCali = calidadRepository.findById(id).get(); 
				if (marca!=null)  tmpCali.setMarca(marca);
				if (pais!=null)  tmpCali.setPais(pais);
				if (descripcion_marca!=null)  tmpCali.setDescripcion_marca(descripcion_marca);
				if (calidad!=null)  tmpCali.setCalidad(calidad);
				calidadRepository.save(tmpCali);
			}else {
				System.out.println("Update -El producto con id " + id + " no existe.");
			}//else
		return tmpCali;
	}//updatecalidad
	
}//class CalidadService
