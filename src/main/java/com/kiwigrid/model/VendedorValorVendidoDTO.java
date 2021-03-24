package com.kiwigrid.model;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class VendedorValorVendidoDTO {
	
	private Vendedor vendedor;
	private Double valorVendido;
	
	public Vendedor getVendedor() {
		return vendedor;
	}
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	public Double getValorVendido() {
		return valorVendido;
	}
	public void setValorVendido(Double valorVendido) {
		this.valorVendido = valorVendido;
	}

}
