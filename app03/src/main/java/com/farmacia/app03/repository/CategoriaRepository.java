package com.farmacia.app03.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.farmacia.app03.model.Categoria;


//Indicando que a interface é do tipo repository
@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	public List<Categoria> findAllBycategoriaContainingIgnoreCase (String categoria);
}