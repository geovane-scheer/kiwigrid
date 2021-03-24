package com.kiwigrid.service;

import java.util.List;

import com.kiwigrid.model.Produto;
import com.kiwigrid.model.ProdutoVenda;
import com.kiwigrid.model.Venda;

public interface ProdutoVendaService {

	void save(Venda venda, List<Produto> produtos);
	
	Iterable<ProdutoVenda> findAll();

	Long countByProduto(Produto produto);
	
}
