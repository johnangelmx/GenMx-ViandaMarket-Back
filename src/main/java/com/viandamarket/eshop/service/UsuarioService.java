package com.viandamarket.eshop.service;
import java.util.List;
import java.util.Optional;
import com.viandamarket.eshop.model.ChangePassword;
import com.viandamarket.eshop.model.Usuario;
import com.viandamarket.eshop.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    
    @Autowired 
	private PasswordEncoder passwordEncoder;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }//UsuarioService

    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }//getAllUsuarios

    public Usuario getUsuario(Long id) {
        return usuarioRepository.findById(id)
        		.orElseThrow(() -> new IllegalArgumentException("El Usuario Con El ID: " + id + " No Existe"));
    }//getUsuario

    public Usuario deleteUsuario(Long id) {
        Usuario tmpUser = null;

        if (usuarioRepository.existsById(id)) {
            tmpUser = usuarioRepository.findById(id).get();
            usuarioRepository.deleteById(id);
        }
        return tmpUser;
    }//deleteUsuario

    public Usuario addUsuario(Usuario usuario) {
        Usuario tmp = null;
        if (usuarioRepository.findByCorreo(usuario.getCorreo()).isEmpty()) {
            usuario.setContrasena(passwordEncoder.encode(usuario.getContrasena())); //Codifica la password
            tmp = usuarioRepository.save(usuario);
        }
        return tmp;
    }

    public Usuario updateUsuarioContrasena(Long id, ChangePassword changePassword) {
        Usuario tmp = null;
        if (usuarioRepository.existsById(id)) {
            if (changePassword.getPassword() != null && changePassword.getNewPassword() != null) {
                tmp = usuarioRepository.findById(id).get();
                if (tmp.getContrasena().equals(changePassword.getPassword())) {
                    tmp.setContrasena(changePassword.getNewPassword());
                    usuarioRepository.save(tmp);
                } else {
                    tmp = null;
                }
            }
        } else {
            System.out.println("Update - El usuario con el id " + id + " no existe");
        }
        return tmp;
    }//updateUsuarioContrasena

    public Usuario updateUsuario(long id, String domicilio, String nombres, String apellidos, Integer edad) {
        Usuario tmpUser = null;
        if (usuarioRepository.existsById(id)) {
            tmpUser = usuarioRepository.findById(id).get();
            if (domicilio != null) tmpUser.setDomicilio(domicilio);
            if (nombres != null) tmpUser.setNombres(nombres);
            if (apellidos != null) tmpUser.setApellidos(apellidos);
            if (edad != null) tmpUser.setEdad(edad);
            usuarioRepository.save(tmpUser);
        }
        return tmpUser;
    }//updateUsuario

    public boolean validateUsuario(Usuario usuario) {
        Optional<Usuario> userByEmail = usuarioRepository.findByCorreo(usuario.getCorreo());
        if (userByEmail.isPresent()) {
            Usuario user = userByEmail.get();
            if (user.getContrasena().equals(usuario.getContrasena())) {
//            if (passwordEncoder.matches(usuario.getContrasena(), user.getContrasena())) { //nuevo encoder
                return true;
            }

        }
        return false;
    }

}
