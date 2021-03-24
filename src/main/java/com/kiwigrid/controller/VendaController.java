package com.kiwigrid.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import com.kiwigrid.model.Produto;
import com.kiwigrid.model.Venda;
import com.kiwigrid.model.VendaDTO;
import com.kiwigrid.model.Vendedor;
import com.kiwigrid.service.ProdutoService;
import com.kiwigrid.service.ProdutoVendaService;
import com.kiwigrid.service.VendaService;
import com.kiwigrid.service.VendedorService;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.validation.Validated;

@Validated
@Controller("/vendas")
public class VendaController {

	@Inject
	private VendaService vendaService;

	@Inject
	private VendedorService vendedorService;
	
	@Inject 
	private ProdutoService produtoService;
	
	@Inject 
	private ProdutoVendaService produtoVendaService;

	@Post()
	public HttpResponse<?> saveVenda(@Body @Valid VendaDTO vendaDTO) {
		List<Produto> produtos = new ArrayList<Produto>();
		Vendedor vendedor = new Vendedor();
		
		//verifica existência do vendedor
		try {
			vendedor = vendedorService.findById(vendaDTO.getIdVendedor()).get();
		} catch (Exception e) {
			return HttpResponse.status(HttpStatus.NOT_FOUND).body("Vendedor não encontrado");
		}

		//verifica preenchimento lista de produtos
		if (vendaDTO.getProdutos() == null || vendaDTO.getProdutos().isEmpty()) {
			return HttpResponse.status(HttpStatus.BAD_REQUEST).body("Ao menos um produto deve ser informado");
		}

		//verifica existência do valor total da venda
		if (vendaDTO.getValorTotal() == null) {
			return HttpResponse.status(HttpStatus.BAD_REQUEST).body("Deve ser informado o valor total da venda");
		}else {
			//verifica existênciua dos produtos da lista
			for(Long idProduto : vendaDTO.getProdutos()) {
				try {
					Produto produto = produtoService.findById(idProduto).get();
					produtos.add(produto);
				} catch (Exception e) {
					//return HttpResponse.status(HttpStatus.NOT_FOUND).body("Produto com ID: " +idProduto+ " não encontrado! Não será incluído na venda!");
				}
			}
		}

		if(!produtos.isEmpty()) {
			//salva a venda
			Venda venda = this.vendaService.save(vendaDTO, vendedor);
			
			//vincula os produtos com a venda
			produtoVendaService.save(venda, produtos);
			
			return HttpResponse.status(HttpStatus.CREATED).body(vendaDTO);
		}else {
			return HttpResponse.status(HttpStatus.NOT_FOUND).body("Nenhum produto da lista foi encontrado!");
		}
	}
	
	@Get()
    public HttpResponse<?> getVendas() {
        return HttpResponse.status(HttpStatus.OK).body(this.vendaService.findAll());
    }
	
	@Get("/produtoVenda")
    public HttpResponse<?> getProdutosVenda() {
        return HttpResponse.status(HttpStatus.OK).body(this.produtoVendaService.findAll());
    }
	
}