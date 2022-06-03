package com.generation.app04.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.generation.app04.model.Produto;
import com.generation.app04.repository.ProdutoRepository;

// Permitir Requisições de outras portas
@CrossOrigin("*")
//Indicar endPoint e que é uma classe controladora
@Controller
@RequestMapping("/produto")
public class ProdutoController {
	// Transferir responsabilidade para o Produto Repository
	@Autowired
	private ProdutoRepository repository;

	// GetAll -> exibe tabela completa
	@GetMapping
	public ResponseEntity<List<Produto>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	// GetById -> exibe pelo id
	@GetMapping("/{id}")
	public ResponseEntity<Produto> GetById(@Valid @PathVariable long id) {
		return repository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
	}

	// GetByValor -> exibe pelo valor
	@GetMapping("/valor/{valor}")
	public ResponseEntity<List<Produto>> GetByValor(@Valid @PathVariable String valor) {
		return ResponseEntity.ok(repository.findAllByValorContainingIgnoreCase(valor));
	}

	// Post -> Insere dados
	@PostMapping
	public ResponseEntity<Produto> Post(@RequestBody Produto produto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produto));
	}

	// Put -> Atualiza dados
	@PutMapping
	public ResponseEntity<Produto> Put(@RequestBody Produto produto) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(produto));
	}

	// Delete -> deleta dados
	@DeleteMapping("/{id}")
	public void delete(@Valid @PathVariable Long id) {
		repository.deleteById(id);
	}
}
