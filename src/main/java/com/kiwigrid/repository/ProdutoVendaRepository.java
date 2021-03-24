package com.kiwigrid.repository;

import com.kiwigrid.model.Produto;
import com.kiwigrid.model.ProdutoVenda;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface ProdutoVendaRepository extends CrudRepository<ProdutoVenda, Long> {

	Long countByProduto(Produto produto); 
	
}