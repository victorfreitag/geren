package com.projetousuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetousuario.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
