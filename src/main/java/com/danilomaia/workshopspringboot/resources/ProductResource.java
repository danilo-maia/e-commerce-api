package com.danilomaia.workshopspringboot.resources;

import com.danilomaia.workshopspringboot.entities.Product;
import com.danilomaia.workshopspringboot.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/products")

public class ProductResource {

    private final ProductService service;

    public ProductResource(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAll(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){
        Product u = service.findById(id);

        if (u != null){
            return ResponseEntity.ok().body(service.findById(id));
        } else {
            return ResponseEntity.notFound().build();
        }

    }
}
