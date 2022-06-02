
// Model serve para criar tabelas
package com.farmacia.app03.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_produto")
public class Produto {
	// Usar long minusculo em tudo
	// Criando chave primária
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	// Criando colunas da tabela
	@NotNull
	private String produto;
	@NotNull
	private String valor;

	// Criando chave externa
	@ManyToOne
	@JsonIgnoreProperties("produto1")
	private Categoria categoria1;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public Categoria getCategoria1() {
		return categoria1;
	}

	public void setCategoria1(Categoria categoria1) {
		this.categoria1 = categoria1;
	}
}
