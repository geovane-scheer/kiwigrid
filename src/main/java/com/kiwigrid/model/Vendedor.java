package com.kiwigrid.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import io.micronaut.core.annotation.Introspected;

@Entity
@Introspected
public class Vendedor {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@NotEmpty(message = "can not be empty")
    private String matricula;
	
	@NotEmpty(message = "can not be empty")
    private String nome;

    public Vendedor(String nome, String matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }
    
    public Vendedor() {}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
    
}