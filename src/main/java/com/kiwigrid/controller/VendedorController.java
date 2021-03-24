package com.kiwigrid.controller;

import javax.inject.Inject;
import javax.validation.Valid;

import com.kiwigrid.model.Vendedor;
import com.kiwigrid.service.VendedorService;

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
@Controller("/vendedores")
public class VendedorController {

    @Inject
    private VendedorService vendedorService;

    @Get()
    public HttpResponse<?> getVendedores() {
        return HttpResponse.status(HttpStatus.OK).body(this.vendedorService.findAll());
    }
    
    @Post()
    public HttpResponse<?> saveVendedor(@Body @Valid Vendedor vendedor) {
        this.vendedorService.save(vendedor);
        return HttpResponse.status(HttpStatus.CREATED).body(vendedor);
    }
    
    @Get("/{matricula}")
    public HttpResponse<?> getVendedorByMatricula(String matricula) {
        return HttpResponse.status(HttpStatus.OK).body(this.vendedorService.findByMatricula(matricula));
    }
    
    @Put("/{id}")
    public HttpResponse<?> updateVendedor(Long id, @Body @Valid Vendedor vendedor) {
    	Vendedor vendedorUpdate = vendedorService.findById(id).get();
    	if(vendedorUpdate != null) {
    		vendedorUpdate.setMatricula(vendedor.getMatricula());
    		vendedorUpdate.setNome(vendedor.getNome()); 
    		this.vendedorService.update(vendedorUpdate);
    		return HttpResponse.status(HttpStatus.OK).body(vendedorUpdate);
    	}else {
    		 return HttpResponse.status(HttpStatus.NOT_FOUND).body("Vendedor com o ID: " + id + " não encontrado!");
    	}
    }
    
    @Delete("/{id}")
    public HttpResponse<?> deleteVendedor(Long id) {
    	Vendedor vendedorDelete = vendedorService.findById(id).get();
    	if(vendedorDelete != null) {
    		this.vendedorService.delete(vendedorDelete);
    		return HttpResponse.status(HttpStatus.OK).body(vendedorDelete);
    	}else {
    		return HttpResponse.status(HttpStatus.NOT_FOUND).body("Vendedor com o ID: " + id + " não encontrado!");
    	}
    }
    
}