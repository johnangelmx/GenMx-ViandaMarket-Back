package com.viandamarket.eshop.controller;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.ServletException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.viandamarket.eshop.model.Token;
import com.viandamarket.eshop.model.Usuario;
import com.viandamarket.eshop.service.UsuarioService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping(path="/api/login/")
public class loginController {
	private final UsuarioService usuarioService;
	
	@Autowired
	public loginController(UsuarioService usuarioService) {
		this.usuarioService=usuarioService;
	}
	
	@PostMapping
	public Token loginUsuario(@RequestBody Usuario usuario) throws ServletException {
		if(usuarioService.validateUsuario(usuario)) {
			return new Token(generateToken(usuario.getCorreo()));
		}//if validateUsuario
		throw new ServletException("Nombre de usuario o contraseña incorrectos");
	}//loginUsuario
	
	private String generateToken(String username) {
		Calendar calendar=Calendar.getInstance();
		calendar.add(Calendar.HOUR,360);
		return Jwts.builder().setSubject(username).claim("role","user")
		.setIssuedAt(new Date()).setExpiration(calendar.getTime())
		.signWith(SignatureAlgorithm.HS256,"JwtFilter.secret")
		.compact();
	}
}//class loginController 
