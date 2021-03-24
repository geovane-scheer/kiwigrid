package com.kiwigrid.service;

import java.util.Optional;

import javax.validation.Valid;

import com.kiwigrid.model.Vendedor;

public interface VendedorService {

	Iterable<Vendedor> findAll();

	void save(@Valid Vendedor vendedor);

	Vendedor findByMatricula(String matricula);

	void update(@Valid Vendedor vendedor);

	Optional<Vendedor> findById(Long id);

	void delete(Vendedor vendedorDelete);
	
}
