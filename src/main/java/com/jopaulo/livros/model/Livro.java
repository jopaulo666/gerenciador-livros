package com.jopaulo.livros.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 50)
	private String titulo;

	@Column(nullable = false, length = 50)
	private String autor;

	@Column(nullable = false, length = 50)
	private String descricao;

	private Long isbn;

	private Long ano;

	private Long paginas;

	@Column
	private LocalDate dataCadastro;

}
