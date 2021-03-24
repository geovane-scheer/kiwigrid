package com.kiwigrid.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import com.kiwigrid.model.Produto;
import com.kiwigrid.model.ProdutoQuantidadeVendasDTO;
import com.kiwigrid.service.ProdutoService;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;
import io.micronaut.validation.Validated;


@Validated
@Controller("/produtos")
public class ProdutoController {

    @Inject
    private ProdutoService produtoService;

    @Get()
    public HttpResponse<?> getProdutos() {
        return HttpResponse.status(HttpStatus.OK).body(this.produtoService.findAll());
    }
    
    @Post()
    public HttpResponse<?> saveProduto(@Body @Valid Produto produto) {
        this.produtoService.save(produto);
        return HttpResponse.status(HttpStatus.CREATED).body(produto);
    }
    
    @Put("/{id}")
    public HttpResponse<?> updateProduto(Long id, @Body @Valid Produto produto) {
    	Produto produtoUpdate = produtoService.findById(id).get();
    	if(produtoUpdate != null) {
    		produtoUpdate.setPreco(produto.getPreco());
    		produtoUpdate.setNome(produto.getNome()); 
    		this.produtoService.update(produtoUpdate);
    		return HttpResponse.status(HttpStatus.OK).body(produtoUpdate);
    	}else {
    		 return HttpResponse.status(HttpStatus.NOT_FOUND).body("Produto com o ID: " + id + " não encontrado!");
    	}
    }
    
    @Delete("/{id}")
    public HttpResponse<?> deleteProduto(Long id) {
    	Produto produtoDelete = produtoService.findById(id).get();
    	if(produtoDelete != null) {
    		this.produtoService.delete(produtoDelete);
    		return HttpResponse.status(HttpStatus.OK).body(produtoDelete);
    	}else {
    		return HttpResponse.status(HttpStatus.NOT_FOUND).body("Produto com o ID: " + id + " não encontrado!");
    	}
    }
    
    @Get("/maisVendidos")
    public HttpResponse<?> getProdutosMaisVendidos() {
        List<ProdutoQuantidadeVendasDTO> retorno = new ArrayList<ProdutoQuantidadeVendasDTO>();
        List<Produto> produtos = (List<Produto>) produtoService.findAll();
        
        if(!produtos.isEmpty()) {
        	for(Produto produto : produtos) {
        		
        	}
        }else {
        	return HttpResponse.status(HttpStatus.NOT_FOUND).body("Nenhum produto foi encontrado!");
        }
        
        return HttpResponse.status(HttpStatus.OK).body(retorno);
    }
}