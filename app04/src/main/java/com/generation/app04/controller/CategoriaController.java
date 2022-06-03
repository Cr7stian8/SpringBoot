package com.generation.app04.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.app04.model.Categoria;
import com.generation.app04.repository.CategoriaRepository;

// Indicar endpoint e tipo da camada e requisições de outras fontes
@RestController
@RequestMapping("/categoria")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoriaController {
	// Transferindo responsabilidade para repitório do produto
	@Autowired
	private CategoriaRepository r;

	// GetAll
	// Indicando que é um método Get
	@GetMapping
	public ResponseEntity<List<Categoria>> GetAll() {
		return ResponseEntity.ok(r.findAll());
	}

	// Getbyid
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> GetById(@Valid @PathVariable Long id) {
		return r.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
	}

	// GetByGenero
	@GetMapping("/genero/{genero}") // Sempre que tiver {} chaves é @pathVariable
	public ResponseEntity<List<Categoria>> GetByGenero(@Valid @PathVariable String genero){
		return ResponseEntity.ok(r.findAllByGeneroContainingIgnoreCase(genero));
	}
	// Post
	@PostMapping
	public ResponseEntity<Categoria> AdicionaTema(@RequestBody Categoria categoria) {
		return ResponseEntity.status(HttpStatus.CREATED).body(r.save(categoria));
	}
	// Put
	@PutMapping
	public ResponseEntity<Categoria> atualizaTema(@RequestBody Categoria categoria) {
		return ResponseEntity.ok(r.save(categoria));
	}	
	// Delete
	@DeleteMapping("/{id}")
	public void deletaTema(@PathVariable long id) {
		r.deleteById(id);
	}
}












