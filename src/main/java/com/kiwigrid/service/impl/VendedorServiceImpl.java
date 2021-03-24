package com.kiwigrid.service.impl;

import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.validation.Valid;

import com.kiwigrid.model.Vendedor;
import com.kiwigrid.repository.VendedorRepository;
import com.kiwigrid.service.VendedorService;

@Singleton
public class VendedorServiceImpl implements VendedorService{

	@Inject
    private VendedorRepository vendedorRepository;
	
	@Override
	public Iterable<Vendedor> findAll() {
		return vendedorRepository.findAll();
	}

	@Override
	public void save(@Valid Vendedor vendedor) {
		vendedorRepository.save(vendedor);
	}

	@Override
	public Vendedor findByMatricula(String matricula) {
		return vendedorRepository.findByMatricula(matricula);
	}

	@Override
	public void update(@Valid Vendedor vendedor) {
		vendedorRepository.update(vendedor);
	}

	@Override
	public Optional<Vendedor> findById(Long id) {
		return vendedorRepository.findById(id);
	}

	@Override
	public void delete(Vendedor vendedorDelete) {
		vendedorRepository.delete(vendedorDelete);
	}

}
