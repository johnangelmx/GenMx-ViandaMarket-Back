package com.viandamarket.eshop.controller; 
import java.util.List; 
import com.viandamarket.eshop.model.Complemento;
import com.viandamarket.eshop.service.ComplementoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//CRUD Create - Read - Update - Delete
//HTTP POST   - GET  - PUT    - DELETE
//API Rest
@RestController
@CrossOrigin(origins = "*")
@RequestMapping (path="/api/complementos/")
public class ComplementosController {
private final ComplementoService complementoService;

	@Autowired
	public  ComplementosController(ComplementoService complementoService) {
		this.complementoService=complementoService;
	}
	
	//-- GETs -Read
	// Gets para todos
	@GetMapping
	public List<Complemento> getAllComplementos(){
		return complementoService.getAllComplementos();
	}
	
	// Gets para uno en especifico
	@GetMapping (path="{complementoId}")
	public Complemento getComplemento(@PathVariable ("complementoId") Long id) {
		return complementoService.getComplemento(id);		
	}
	
	//-- DELETE - Delete
	// Delete para uno en especifico 
	@DeleteMapping (path="{complementoId}")
	public Complemento deleteComplemento(@PathVariable ("complementoId") Long id) {
		return complementoService.deleteComplemento(id);		
	}
	
	//-- Posts - Create
	// Post para crear un elemento en especifico
	@PostMapping 
	public Complemento addComplemento(@RequestBody Complemento complemento) {
		return complementoService.addComplemento(complemento);
	}  
	
	//-- Put - Update
	// Put para crear un elemento en especifico
	@PutMapping (path="{complementoId}")
	public Complemento addComplemento(@PathVariable("complementoId") long id,
			@RequestParam(required = false)	String nombre, 
			@RequestParam(required = false)	Boolean disponibilidad, 
			@RequestParam(required = false)	Integer cantidad_disponible, 
			@RequestParam(required = false)	String descripcion_complemento,
			@RequestParam(required = false)	Float precio)
	{	

//		String nombre, boolean disponibilidad, int cantidad_disponible, 
//		String descripcion_complemento,	double precio
		return complementoService.updateComplemento(id, nombre,disponibilidad, 
				cantidad_disponible, descripcion_complemento,precio);
	} 
}//class ComplementosController
