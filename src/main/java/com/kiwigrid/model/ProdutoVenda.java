package com.kiwigrid.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import io.micronaut.core.annotation.Introspected;

@Entity
@Introspected
public class ProdutoVenda {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "venda_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Venda venda;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "produto_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Produto produto;
	
	public ProdutoVenda(Venda venda, Produto produto) {
        this.venda = venda;
        this.produto = produto;
    }
	
	public ProdutoVenda() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}