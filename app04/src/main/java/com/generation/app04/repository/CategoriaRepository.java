package com.generation.app04.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.app04.model.Categoria;

//indicando que a camada é do tipo repository
@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	public List<Categoria> findAllByGeneroContainingIgnoreCase (String genero);
}
