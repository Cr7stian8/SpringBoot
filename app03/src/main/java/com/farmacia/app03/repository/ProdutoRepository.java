package com.farmacia.app03.repository;



import java.util.List;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farmacia.app03.model.Produto;


public interface ProdutoRepository extends JpaRepository<Produto, Long >{
	public List<Produto> findAllByvalorContainingIgnoreCase (String valor);

	public void deleteById(@Valid String id);

}
