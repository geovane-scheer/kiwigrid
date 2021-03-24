package com.kiwigrid.model;

import java.util.List;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class VendaDTO {
	
	private Long idVendedor;
	private Double valorTotal;
	private List<Long> produtos;
	
	public Long getIdVendedor() {
		return idVendedor;
	}
	
	public void setIdVendedor(Long idVendedor) {
		this.idVendedor = idVendedor;
	}
	
	public Double getValorTotal() {
		return valorTotal;
	}
	
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public List<Long> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Long> produtos) {
		this.produtos = produtos;
	}

}
