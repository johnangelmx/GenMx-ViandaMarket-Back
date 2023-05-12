package com.viandamarket.eshop.repository;

import com.viandamarket.eshop.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // TODO metodo para buscar usuarios repetidos
    Optional<Usuario> findByCorreo(String correo);
}//* Interface Usuario
