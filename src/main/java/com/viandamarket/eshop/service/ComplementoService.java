package com.viandamarket.eshop.service;
import java.util.List;
import com.viandamarket.eshop.model.Complemento;
import com.viandamarket.eshop.repository.ComplementoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComplementoService {
	private final ComplementoRepository complementoRepository;

	// Genera automaticamente al levantar el servidor
	// como los seeders de laravel (?
	@Autowired
	public ComplementoService(ComplementoRepository complementoRepository) {
		this.complementoRepository = complementoRepository;

	}

	public List<Complemento> getAllComplementos() {
		return complementoRepository.findAll();
	}

	public Complemento getComplemento(Long id) {
		return complementoRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Complemento con Id: " + id + " no existe."));
	}

	public Complemento deleteComplemento(Long id) {
		Complemento tmComplemento = null;
		if (complementoRepository.existsById(id)) {
			tmComplemento = complementoRepository.findById(id).get();
			complementoRepository.deleteById(id);
		}
		return tmComplemento;
	}

	public Complemento addComplemento(Complemento complemento) {
		return complementoRepository.save(complemento);

	}

	public Complemento updateComplemento(
			long id,
			String nombre, 
			Boolean disponibilidad, 
			Integer cantidad_disponible,
			String descripcion_complemento,
			Float precio
			) {
		Complemento tmComplemento = null;
		if (complementoRepository.existsById(id)) {
			tmComplemento = complementoRepository.findById(id).get();			
			if (nombre != null) tmComplemento.setNombre(nombre);
			if (disponibilidad != null) tmComplemento.setDisponibilidad(disponibilidad);
			if (cantidad_disponible != null) tmComplemento.setCantidad_disponible(cantidad_disponible);
			if (descripcion_complemento != null) tmComplemento.setDescripcion_complemento(descripcion_complemento);			
			if (precio != null) tmComplemento.setPrecio(precio.floatValue());
			
			complementoRepository.save(tmComplemento);
		} else {
			System.out.println("Update - El complemento con id " + id + " no existe");
		}
		return tmComplemento;
	}
}
//		for (Complemento complemento : lista) {
//			if (complemento.getId()==id) {
//				
//				if (nombre!=null) complemento.setNombre(nombre);
//				if (precio!=null) complemento.setPrecio(precio.doubleValue());
//				if (descripcion_complemento!=null) complemento.setDescripcion_complemento(descripcion_complemento);
//				if (disponibilidad!=null) complemento.setDisponibilidad(disponibilidad);
//				if (cantidad_disponible!=null) complemento.setCantidad_disponible(cantidad_disponible);
//				tmComplemento =complemento;
//				break;
//			}
//		}
//	}
// 
//}
