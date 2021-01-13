package com.jopaulo.livros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jopaulo.livros.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
