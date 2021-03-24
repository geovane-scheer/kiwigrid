package com.kiwigrid.service.impl;

import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.validation.Valid;

import com.kiwigrid.model.Produto;
import com.kiwigrid.repository.ProdutoRepository;
import com.kiwigrid.service.ProdutoService;

@Singleton
public class ProdutoServiceImpl implements ProdutoService{

	@Inject
    private ProdutoRepository produtoRepository;

	@Override
	public Iterable<Produto> findAll() {
		return produtoRepository.findAll();
	}

	@Override
	public void save(@Valid Produto produto) {
		produtoRepository.save(produto);
	}

	@Override
	public void update(@Valid Produto produto) {
		produtoRepository.update(produto);
	}

	@Override
	public Optional<Produto> findById(Long id) {
		return produtoRepository.findById(id);
	}

	@Override
	public void delete(Produto produtoDelete) {
		produtoRepository.delete(produtoDelete);
	}

}
