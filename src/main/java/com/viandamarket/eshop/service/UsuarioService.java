package com.viandamarket.eshop.service;

import java.util.ArrayList; 

import com.viandamarket.eshop.model.Usuario; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
	private final ArrayList<Usuario> lista = new ArrayList<>();
	//Genera automaticamente al levantar el servidor
	//como los seeders de laravel (? 
	@Autowired
	public UsuarioService() {
		lista.add(new Usuario( "Eje Central, Colonia Zapata","Francisco","Salinas","FranSal@gmail.com","#HolaMundo1",25 ));
		lista.add(new Usuario( "Avenida Libertador, Colonia Paso Limonero","Gerardo","Mendoza","MenGer@gmail.com","%Rinoceronte23",26 ));
		lista.add(new Usuario( "Avenida Unidos, Colonia Renacimiento","Moises","Rodriguez","Moi@gmail.com","&Nopales95",27 ));
		lista.add(new Usuario( "Avenida Renacimiento, Colonia Las Cruces","Andrea","Hernandez","Andrea@gmail.com","*Automobil7",28 ));
		lista.add(new Usuario( "Avenida Lopez Mateos, Colonia Coasta Azul","Carolina","Lopez","Caro@gmail.com","@Europa85",25 ));
	}//constructor

	public ArrayList<Usuario> getAllUsuarios() {
		// TODO Auto-generated method stub
		return lista;
	}

	public Usuario getUsuario(Long id) {
		Usuario tmUser=null;
		for (Usuario usuario : lista) {
			if (usuario.getId()==id) {
				tmUser= usuario;
				
			}
		}
		return tmUser;
	}

	public Usuario deleteUsuario(Long id) {
		Usuario tmUser=null;
		for (Usuario usuario : lista) {
			if (usuario.getId()==id) {
				tmUser =  lista.remove(lista.indexOf(usuario));
				break;
			}
		}
		return tmUser;
	}

	public Usuario addUsuario(Usuario usuario) {
		lista.add(usuario);
		return usuario;
	}

	public Usuario updateUsuario(long id, String domicilio, String nombres, String apellidos, String correo,
			String contrasenia, Integer edad) {
		Usuario tmUser=null;
		for (Usuario usuario : lista) {
			if (usuario.getId()==id) {
				if (domicilio!=null)  usuario.setDomicilio(domicilio);
				if (nombres!=null)  usuario.setNombres(nombres);
				if (apellidos!=null)  usuario.setApellidos(apellidos);
				if (correo!=null)  usuario.setCorreo(correo);
				if (contrasenia!=null)  usuario.setContrasenia(contrasenia);
				if (edad!=null)  usuario.setEdad(edad);
				tmUser =  usuario;
				break;
			}
		}
		return tmUser;
	}

}
