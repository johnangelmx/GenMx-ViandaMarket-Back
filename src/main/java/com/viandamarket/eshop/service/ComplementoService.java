package com.viandamarket.eshop.service;
import java.util.ArrayList; 
import com.viandamarket.eshop.model.Complemento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComplementoService {
	private final ArrayList<Complemento> lista = new ArrayList<>();
	//Genera automaticamente al levantar el servidor
	//como los seeders de laravel (? 
	@Autowired
	public ComplementoService() {
		lista.add(new Complemento("complemento", 20.20, "Descripcion", true, 25));
		lista.add(new Complemento("complemento", 20.20, "Descripcion", true, 25));
		lista.add(new Complemento("complemento", 20.20, "Descripcion", true, 25));
		lista.add(new Complemento("complemento", 20.20, "Descripcion", true, 25));
		lista.add(new Complemento("complemento", 20.20, "Descripcion", true, 25));
	}
	public ArrayList<Complemento> getAllComplementos() {
		System.out.println(lista);
		return lista;		
	}
	public Complemento getComplemento(Long id) {
		Complemento tmComplemento=null;
		for (Complemento usuario : lista) {
			if (usuario.getId()==id) {
				tmComplemento= usuario;				
			}
		}
		return tmComplemento;
	}
	public Complemento deleteComplemento(Long id) {
		Complemento tmComplemento=null;
		for (Complemento usuario : lista) {
			if (usuario.getId()==id) {
				tmComplemento =  lista.remove(lista.indexOf(usuario));
				break;
			}
		}
		return tmComplemento;
	}
	public Complemento addComplemento(Complemento complemento) {
		lista.add(complemento);
		return complemento;
	}
//	public Complemento updateComplemento(long id, String nombre, Double precio, String descripcion_complemento, Boolean disponibilidad,
//            Integer cantidad_disponible, Long idcalidades) {
//		Complemento tmComplemento=null;
//		for (Complemento complemento : lista) {
//			if (complemento.getId()==id) {
//				if (nombre!=null) complemento.setNombre(nombre);
//				if (precio!=null) complemento.setPrecio(precio.doubleValue());
//				if (descripcion_complemento!=null) complemento.setDescripcion_complemento(descripcion_complemento);
//				if (disponibilidad!=null) complemento.setDisponibilidad(disponibilidad);
//				if (cantidad_disponible!=null) complemento.setCantidad_disponible(cantidad_disponible);
//				tmComplemento =complemento;
//				break;
//			}
//		}
//		return tmComplemento;
//	}
	
	public Complemento updateComplemento(long id, String nombre, Double precio, String descripcion_complemento,
			Boolean disponibilidad, Integer cantidad_disponible) {
		Complemento tmComplemento=null;
		for (Complemento complemento : lista) {
			if (complemento.getId()==id) {
				
				if (nombre!=null) complemento.setNombre(nombre);
				if (precio!=null) complemento.setPrecio(precio.doubleValue());
				if (descripcion_complemento!=null) complemento.setDescripcion_complemento(descripcion_complemento);
				if (disponibilidad!=null) complemento.setDisponibilidad(disponibilidad);
				if (cantidad_disponible!=null) complemento.setCantidad_disponible(cantidad_disponible);
				tmComplemento =complemento;
				break;
			}
		}
		return tmComplemento;
	}
 
}
