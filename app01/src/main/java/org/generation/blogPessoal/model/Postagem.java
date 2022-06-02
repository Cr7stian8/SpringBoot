package org.generation.blogPessoal.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
//esse comando faz com que essa classe seja interpretada pelo banco de dados como entidade
@Entity 
//esse comando faz criar a tabela dentro do banco de dados
@Table(name = "postagem") 
public class Postagem {

	// Criando chave_primaria e auto_increment
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	//especificando que o valor é não nulo e quantidade min e max do título e texto
	@NotNull 
	@Size(min=5, max=100)
	private String titulo;
	@NotNull
	@Size(min=5, max=500)
	private String texto;
	
	@Temporal(TemporalType.TIMESTAMP)
	
	// calcula a hora exato que o objeto entra na classe
	private Date data = new java.sql.Date(System.currentTimeMillis()); 

	//Getters and setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}
