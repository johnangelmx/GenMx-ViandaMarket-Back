package com.viandamarket.eshop.service;

import java.util.ArrayList;
import java.util.List;

import com.viandamarket.eshop.model.ChangePassword;
import com.viandamarket.eshop.model.Usuario;
import com.viandamarket.eshop.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

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
        Usuario tmpUser = null;
        if (usuarioRepository.findByCorreo(usuario.getCorreo()).isEmpty()) {
            tmpUser = usuarioRepository.save(usuario);
        }
        return tmpUser;
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
    }

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
    }

}
