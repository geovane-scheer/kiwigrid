package com.kiwigrid.repository;

import com.kiwigrid.model.Venda;
import com.kiwigrid.model.Vendedor;

import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface VendaRepository extends CrudRepository<Venda, Long> {

	Long countByVendedor(Vendedor vendedor);

	@Query(value = "SELECT SUM(v.valorTotal) FROM Venda v WHERE v.vendedor.id = :id")
	double findValorVendidoByVendedor(Long id); 
	
}