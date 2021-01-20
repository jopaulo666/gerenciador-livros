package com.jopaulo.livro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Usuario {

	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 50, unique = true, name = "login")
	@NotEmpty(message = "{campo.login.obrigatorio}")
	private String username;
	
	@Column(nullable = false, length = 50, name = "senha")
	@NotEmpty(message = "{campo.senha.obrigatorio}")
	private String password;
}
