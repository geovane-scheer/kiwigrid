package com.kiwigrid.service;

import javax.validation.Valid;

import com.kiwigrid.model.Venda;
import com.kiwigrid.model.VendaDTO;
import com.kiwigrid.model.Vendedor;

public interface VendaService {

	Venda save(@Valid VendaDTO vendaDTO, Vendedor vendedor);

	Iterable<Venda> findAll();

	Long countByVendedor(Vendedor vendedor);

	Double findValorVendidoByVendedor(Vendedor vendedor);

}
