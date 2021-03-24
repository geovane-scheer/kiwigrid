package com.kiwigrid.service.impl;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.validation.Valid;

import com.kiwigrid.model.Venda;
import com.kiwigrid.model.VendaDTO;
import com.kiwigrid.model.Vendedor;
import com.kiwigrid.repository.VendaRepository;
import com.kiwigrid.service.VendaService;

@Singleton
public class VendaServiceImpl implements VendaService{

	@Inject
    private VendaRepository vendaRepository;

	@Override
	public Venda save(@Valid VendaDTO vendaDTO, Vendedor vendedor) {
		Venda venda = new Venda(vendaDTO.getValorTotal(), vendedor);
		return vendaRepository.save(venda);
	}

	@Override
	public Iterable<Venda> findAll() {
		return vendaRepository.findAll();
	}

}
