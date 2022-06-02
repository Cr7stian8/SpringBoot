package com.generation.helloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//precisa indicar que é controladora
@RestController

//Serve para construir os endPoints da api
@RequestMapping("/hello")

public class helloWorld {
	@GetMapping
	public String mentalidades() {
		return "Mentalidades: Orientação ao futuro, Responsabilidade Pessoal, "
				+ "Mentalidade de Crescimento, Persistência <br> Habilidades: "
				+ "Trabalhos em Equipe, Atenção aos Detalhes, Proatividade, Comunicação";
	}
}