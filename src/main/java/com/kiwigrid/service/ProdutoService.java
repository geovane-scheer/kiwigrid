package com.kiwigrid.service;

import java.util.Optional;

import javax.validation.Valid;

import com.kiwigrid.model.Produto;

public interface ProdutoService {

	Iterable<Produto> findAll();

	void save(@Valid Produto produto);

	void update(@Valid Produto produto);

	Optional<Produto> findById(Long id);

	void delete(Produto produtoDelete);
	
}
