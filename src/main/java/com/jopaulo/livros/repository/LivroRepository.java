package com.jopaulo.livros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jopaulo.livro.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{

}
