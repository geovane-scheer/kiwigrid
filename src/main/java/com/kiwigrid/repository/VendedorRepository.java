package com.kiwigrid.repository;

import com.kiwigrid.model.Vendedor;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface VendedorRepository extends CrudRepository<Vendedor, Long> {

	Vendedor findByMatricula(String matricula); 
	
}