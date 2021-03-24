package com.kiwigrid.repository;

import com.kiwigrid.model.Produto;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long> {

}