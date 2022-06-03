package com.generation.app04.model;

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

@Entity
@Table(name = "tb_categoria")
public class Categoria {
	// Criando chave primária
	// Usar Long minusculo em tudo
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// Criando colunas da tabela
	//Gênero se refere ao tipo do jogo!, ex: luta, corrida...
	@NotNull
	private String genero;

	// players se refere a quantidade de players, ex: 2 jogadores ...
	@NotNull
	private String players;

	// criando chave externa
	// Cascadetype = all significa que ao mudar uma categoria todos os produtos
	// mudarão também ao invés de serem deletados
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("categoria")
	private List<Produto> produto;

	// Criando getters and setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getPlayers() {
		return players;
	}

	public void setPlayers(String players) {
		this.players = players;
	}

	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}

}
