package com.viandamarket.eshop.controller;

import com.viandamarket.eshop.model.ChangePassword;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import com.viandamarket.eshop.config.JwtFilter;
import com.viandamarket.eshop.model.Token;
import com.viandamarket.eshop.model.Usuario;
import com.viandamarket.eshop.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.ServletException;
import java.util.Calendar;
import java.util.Date;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/login/")
public class loginController {
    private final UsuarioService usuarioService;

    @Autowired
    public loginController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    //    @PostMapping
//    public Token loginUsuario(@RequestBody Usuario usuario) throws ServletException {
//        try {
//            Usuario tmpUsuario = null;
//            if (usuarioService.validateUsuario(usuario)) {
//                return new Token(generateToken(usuario.getContrasena()));
//            }
//            throw new ServletException("nombre usuario o contrasena incorretos");
//        } catch (ServletException ex) {
//            // Aquí puedes realizar cualquier acción necesaria, como loguear el error
//            // y devolver una respuesta HTTP adecuada, por ejemplo:
//            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "nombre usuario o contrasena incorretos", ex);
//        }
//    }
    @PostMapping
    public Token loginUsuario(@RequestBody Usuario usuario) {
        if (usuarioService.validateUsuario(usuario) != 0L) {
            String token = generateToken(usuario.getContrasena());
            return new Token(token, usuarioService.validateUsuario(usuario));
        }
        return null;
    }


    @PutMapping(path = "{userId}")
    public Usuario updateUsuarioContrasena(@PathVariable("userId") long id, @RequestBody ChangePassword changePassword) {
        return usuarioService.updateUsuarioContrasena(id, changePassword);
    }

    //? Metodo para generar token ⬇
    private String generateToken(String username) {
        // Creando calendario para establecer tiempo de caducidad de JWT ⬇️
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.WEEK_OF_MONTH, 2);
        // Creando instancia JWT ⬇️
        return Jwts.builder() // Retorna y crea los parametros para generar el token
                .setSubject(username) // Subjet nombre usuario
                .claim("role", "user") //  asignacion nombre valor
                .setIssuedAt(new Date()) // datos actuales
                .setExpiration(calendar.getTime()) // datos fecha de expiracion
                .signWith(SignatureAlgorithm.HS256, JwtFilter.secret) // tipo de encriptacion más frase de seguridad
                .compact();
    }// ⬆ Method generateToken
}// class logincontroller

