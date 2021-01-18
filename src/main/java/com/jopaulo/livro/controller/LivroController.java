package com.jopaulo.livro.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.jopaulo.livro.model.Livro;
import com.jopaulo.livros.repository.LivroRepository;

@RestController
@RequestMapping("/api/livros")
@CrossOrigin("http://localhost:4200")
public class LivroController {

	@Autowired
	private LivroRepository repository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Livro salvar(@RequestBody @Valid Livro livro) {
		return repository.save(livro);
	}
	
	@GetMapping("{id}")
	public Livro buscar(@PathVariable Long id) {
		return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void excluir(@PathVariable Long id) {
		repository.findById(id)
			.map(Livro -> {
				repository.delete(Livro); 
				return Void.TYPE;
			})
			.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro não encontrado"));
	}
	
	@PutMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizar(@PathVariable Long id, @RequestBody Livro livroAtualizada) {
		repository.findById(id)
			.map(Livro -> {
				livroAtualizada.setId(Livro.getId());
				return repository.save(livroAtualizada);
			})
			.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro não encontrado"));
	}
}
