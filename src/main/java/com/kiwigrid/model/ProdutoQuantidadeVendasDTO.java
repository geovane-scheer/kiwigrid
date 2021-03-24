package com.kiwigrid.model;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class ProdutoQuantidadeVendasDTO {
	
	private Produto produto;
	private Long quantidadeDeVendas;
	
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public Long getQuantidadeDeVendas() {
		return quantidadeDeVendas;
	}
	public void setQuantidadeDeVendas(Long quantidadeDeVendas) {
		this.quantidadeDeVendas = quantidadeDeVendas;
	}
	
}
