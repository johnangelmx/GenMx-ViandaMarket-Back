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
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario getUsuario(Long id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("El Usuario Con El ID: " + id + " No Existe"));
    }

    public Usuario deleteUsuario(Long id) {
        Usuario tmpUser = null;
        if (usuarioRepository.existsById(id)) {
            tmpUser = usuarioRepository.findById(id).get();
            usuarioRepository.deleteById(id);
        }
        return tmpUser;
    }

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
            if (changePassword.getContrasena() != null && changePassword.getNewContrasena() != null) {
                tmp = usuarioRepository.findById(id).get();
                if (passwordEncoder.matches(changePassword.getContrasena(), tmp.getContrasena())) { // nuevo encoder
                    tmp.setContrasena(passwordEncoder.encode(changePassword.getNewContrasena()));
                    usuarioRepository.save(tmp);
                } else {
                    tmp = null;
                }
            }
        } else {
            System.out.println("Update - El usuario con el id " + id + " no existe");
        }
        return tmp;
    }

    public Usuario updateUsuario(long id, String correo, String domicilio, String nombres, String apellidos, Integer edad) {
        Usuario tmpUser = null;
        if (usuarioRepository.existsById(id)) {
            tmpUser = usuarioRepository.findById(id).get();
            if (correo != null) tmpUser.setCorreo(correo);
            if (domicilio != null) tmpUser.setDomicilio(domicilio);
            if (nombres != null) tmpUser.setNombres(nombres);
            if (apellidos != null) tmpUser.setApellidos(apellidos);
            if (edad != null) tmpUser.setEdad(edad);
            usuarioRepository.save(tmpUser);
        }
        return tmpUser;
    }

    public Long validateUsuario(Usuario usuario) {
        Long userId = 0L;
        Optional<Usuario> userByEmail = usuarioRepository.findByCorreo(usuario.getCorreo());
        if (userByEmail.isPresent()) {
            Usuario user = userByEmail.get();
//            if (user.getContrasena().equals(usuario.getContrasena())) {
            if (passwordEncoder.matches(usuario.getContrasena(), user.getContrasena())) { //nuevo encoder
                userId = user.getId();
                return userId;
            }

        }
        return userId;
    }

}
