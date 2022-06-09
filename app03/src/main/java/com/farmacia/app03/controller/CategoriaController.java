package com.farmacia.app03.controller;

import java.util.List;

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

import com.farmacia.app03.model.Categoria;
import com.farmacia.app03.repository.CategoriaRepository;

//Indicar endPoint e que é uma classe controladora
@RestController
@RequestMapping("/categoria")

//Permitir Requisições de outras fontes
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoriaController {
	// Transferir responsabilidade para o Produto Repository
	@Autowired
	private CategoriaRepository repository;

	// GetAll
	@GetMapping
	public ResponseEntity<List<Categoria>> Getall() {
		return ResponseEntity.ok(repository.findAll());
	}

	// GetById
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> GetById(@PathVariable long Id) {
		return repository.findById(Id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
	}

	// GetByCategoria
	@GetMapping("/categoria/{categoria}")
	public ResponseEntity<List<Categoria>> getByName(@PathVariable String categoria) {
		return ResponseEntity.ok(repository.findAllBycategoriaContainingIgnoreCase(categoria));
	}

	// Post
	@PostMapping
	public ResponseEntity<Categoria> AdicionaTema(@RequestBody Categoria categoria) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(categoria));
	}

	// Put
	@PutMapping
	public ResponseEntity<Categoria> atualizaTema(@RequestBody Categoria categoria) {
		return ResponseEntity.ok(repository.save(categoria));
	}

	// Delete
	@DeleteMapping("/{id}")
	public void deletaTema(@PathVariable long id) {
		repository.deleteById(id);
	}
}
