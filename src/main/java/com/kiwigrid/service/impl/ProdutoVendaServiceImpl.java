package com.kiwigrid.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.kiwigrid.model.Produto;
import com.kiwigrid.model.ProdutoVenda;
import com.kiwigrid.model.Venda;
import com.kiwigrid.repository.ProdutoVendaRepository;
import com.kiwigrid.service.ProdutoVendaService;

@Singleton
public class ProdutoVendaServiceImpl implements ProdutoVendaService{

	@Inject
    private ProdutoVendaRepository produtoVendaRepository;

	@Override
	public void save(Venda venda, List<Produto> produtos) {
		for(Produto produto : produtos) {
			ProdutoVenda produtoVenda = new ProdutoVenda(venda, produto);
			produtoVendaRepository.save(produtoVenda);
		}
	}

	@Override
	public Iterable<ProdutoVenda> findAll() {
		return produtoVendaRepository.findAll();
	}

	@Override
	public Long countByProduto(Produto produto) {
		return produtoVendaRepository.countByProduto(produto);
	}

}
