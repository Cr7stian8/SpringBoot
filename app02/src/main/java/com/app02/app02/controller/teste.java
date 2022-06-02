package com.app02.app02.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Classe controladora tem que ter o ResController e o ResquestMapping
@RestController
@RequestMapping("/teste")
public class teste {
	/*
	 * Getmapping 
	 * PostMapping
	 * PutMapping
	 * DeleteMapping
	 */
	
	@GetMapping
	public String hello() {
		return "Olá mundo";
	}
}