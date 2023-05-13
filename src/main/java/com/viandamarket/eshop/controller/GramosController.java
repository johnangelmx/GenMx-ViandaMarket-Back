
package com.viandamarket.eshop.controller; 
import java.util.List; 
import com.viandamarket.eshop.service.GramoService;
import com.viandamarket.eshop.model.Gramo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (path="/api/gramos/")
public class GramosController {

	private final GramoService gramoService;
	
	@Autowired
	public  GramosController(GramoService gramoService) {
		this.gramoService = gramoService;		
	}
	//-- GETs -Read
	// Gets para todos
	@GetMapping
	public List<Gramo> getAllGramos(){
		return gramoService.getAllGramos();
	}

	// Gets para uno en especifico
	@GetMapping (path="{gramosId}")
	public Gramo getGramos(@PathVariable ("gramosId") Long id) {
		return gramoService.getGramo(id);
		
	}
	//-- DELETE - Delete
	// Delete para uno en especifico 
	@DeleteMapping (path="{gramosId}")
	public Gramo deleteGramo(@PathVariable ("gramosId") Long id) {
		return gramoService.deleteGramo(id);
		
	}
	//-- Posts - Create
	// Post para crear un elemento en especifico
	@PostMapping 
	public Gramo addGramo(@RequestBody Gramo gramos) {
		return gramoService.addGramo(gramos);
		
	}  
	//-- Put - Update
	// Put para crear un elemento en especifico
	@PutMapping (path="{gramosId}")
	public Gramo addGramo(@PathVariable("gramosId") long idgramos,	
			@RequestParam(required = false)	Double cantidad, 
			@RequestParam(required = false)	Long cortes_idcortes, 
			@RequestParam(required = false)	Long complementos_idcomplementos)
			
	{
		return gramoService.updateGramo(idgramos, cantidad, cortes_idcortes, complementos_idcomplementos);
	} 


}
