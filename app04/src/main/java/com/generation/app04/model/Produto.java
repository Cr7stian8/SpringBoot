package com.generation.app04.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
// Criando tabela
@Table(name = "tb_produto")
public class Produto {
	// Criando chave primária
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// Usar todos longs maiusculos
	private Long id;

	// ---------------- Criando colunas da tabela ----------------
	// Nome se refere ao nome do jogo, ex: Fifa, Mortal kombat ...
	@NotNull
	private String nome;

	// Exemplos de plataformas: console, PC, PS4, Nintendo ...
	@NotNull
	private String plataforma;

	// Valor do preço foi categorizado como string por motivos óbvios. Existem jogos
	// de valor "Sentimental" e também incluí dinheiro R$. Sendo nexessário
	// específicar como String
	@NotNull
	private String valor;

	// Criando chave Externa
	@ManyToOne
	@JsonIgnoreProperties("produto")
	private Categoria categoria;

	// Criando Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
