package com.farmacia.app03.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// Usar long minusculo em tudo
@Entity
@Table(name = "tb_categoria")
public class Categoria {
	// Criando chave primária
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	// Criando coluna da tabela
	@NotNull
	private String categoria;

	// Criando chave externa
	@OneToMany(mappedBy = "categoria1", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("categoria1")
	private List<Produto> produto1;

	// Criando Getters and Setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public List<Produto> getProduto() {
		return produto1;
	}

	public void setProduto(List<Produto> produto) {
		this.produto1 = produto;
	}


	

}