package com.generation.app04.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.app04.model.Produto;

// Indicanndo que a camada é do tipo repository
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	// Método responsável por realizar o select pelo valor no banco de dados
	public List<Produto> findAllByValorContainingIgnoreCase(String valor);
}
