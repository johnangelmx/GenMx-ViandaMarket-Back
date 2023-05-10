package com.viandamarket.eshop.controller;  
import java.util.List; 
import com.viandamarket.eshop.model.Usuario;
import com.viandamarket.eshop.service.UsuarioService;
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


//CRUD Create - Read - Update - Delete
//HTTP POST   - GET  - PUT    - DELETE
//API Rest
@RestController
@RequestMapping (path="/api/usuarios/")
public class UsuarioController {
	private final UsuarioService usuarioService;
	
	@Autowired
	public  UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;		
	}
	//-- GETs -Read
	// Gets para todos
	@GetMapping
	public List<Usuario> getAllProducts(){
		return usuarioService.getAllUsuarios();
	}

	// Gets para uno en especifico
	@GetMapping (path="{prodId}")
	public Usuario getProduct(@PathVariable ("prodId") Long id) {
		return usuarioService.getUsuario(id);
		
	}
	//-- DELETE - Delete
	// Delete para uno en especifico 
	@DeleteMapping (path="{prodId}")
	public Usuario deleteProduct(@PathVariable ("prodId") Long id) {
		return usuarioService.deleteUsuario(id);
		
	}
	//-- Posts - Create
	// Post para crear un elemento en especifico
	@PostMapping 
	public Usuario addProduct(@RequestBody Usuario usuario) {
		return usuarioService.addUsuario(usuario);
		
	} 
	
	//-- Put - Update
	// Put para crear un elemento en especifico
	@PutMapping (path="{prodId}")
	public Usuario addProduct(@PathVariable("prodId") long id,
			@RequestParam(required = false)	String domicilio, 
			@RequestParam(required = false)	String nombres, 
			@RequestParam(required = false)	String apellidos, 
			@RequestParam(required = false)	String correo, 
			@RequestParam(required = false)	String contrasenia, 
			@RequestParam(required = false)	Integer edad) 
	{
		return usuarioService.updateUsuario(id,domicilio,nombres, apellidos, correo,contrasenia,edad);
	}

}
