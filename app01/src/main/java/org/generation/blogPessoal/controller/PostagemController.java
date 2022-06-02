package org.generation.blogPessoal.controller;

import java.util.List;

import org.generation.blogPessoal.model.Postagem;
import org.generation.blogPessoal.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//informando que a classe é do tipo pontroller
@RestController 

//Caminho do site
@RequestMapping("/postagens") 

//esta classe aceita requisição de qualquer origem
@CrossOrigin("*") 
public class PostagemController {
	
	//por conta da debaixo ser uma interface, este comando força que acessemos, mesmo não instanciando
	@Autowired 
	private PostagemRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Postagem>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
}
