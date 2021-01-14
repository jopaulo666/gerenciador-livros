package com.jopaulo.livro.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Livro {

	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 50)
	@NotEmpty(message = "{campo.titulo.obrigatorio}")
	private String titulo;

	@Column(nullable = false, length = 50)
	@NotEmpty(message = "{campo.autor.obrigatorio}")
	private String autor;

	@Column(nullable = false, length = 255)
	@NotEmpty(message = "{campo.descricao.obrigatorio}")
	private String descricao;

	@Column(name = "data_cadastro" ,updatable = false)
	private LocalDate dataCadastro;
	
	@PrePersist
	public void prePersist() {
		setDataCadastro(LocalDate.now());
	}

}
