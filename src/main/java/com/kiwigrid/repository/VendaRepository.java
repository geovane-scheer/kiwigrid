package com.kiwigrid.repository;

import com.kiwigrid.model.Venda;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface VendaRepository extends CrudRepository<Venda, Long> { }