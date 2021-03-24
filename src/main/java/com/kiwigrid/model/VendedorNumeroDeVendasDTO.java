package com.kiwigrid.model;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class VendedorNumeroDeVendasDTO {
	
	private Vendedor vendedor;
	private Long numeroDeVendas;
	
	public Vendedor getVendedor() {
		return vendedor;
	}
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	public Long getNumeroDeVendas() {
		return numeroDeVendas;
	}
	public void setNumeroDeVendas(Long numeroDeVendas) {
		this.numeroDeVendas = numeroDeVendas;
	}

}
