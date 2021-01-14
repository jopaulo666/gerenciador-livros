package com.jopaulo.livro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.jopaulo.livro.model.Livro;
import com.jopaulo.livros.repository.LivroRepository;

@RestController
@RequestMapping("/api/livros")
public class LivroController {

	@Autowired
	private LivroRepository repository;
	
	@PostMapping
	public Livro salvar(@RequestBody Livro livro) {
		return repository.save(livro);
	}
	
	@GetMapping("{id}")
	public Livro buscar(@PathVariable Long id) {
		return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
}
