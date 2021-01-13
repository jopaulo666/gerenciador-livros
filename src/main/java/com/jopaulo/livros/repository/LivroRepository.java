package com.jopaulo.livros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jopaulo.livros.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{

}
