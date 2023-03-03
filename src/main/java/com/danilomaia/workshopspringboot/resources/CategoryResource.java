package com.danilomaia.workshopspringboot.resources;

import com.danilomaia.workshopspringboot.entities.Category;
import com.danilomaia.workshopspringboot.services.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")

public class CategoryResource {

    private final CategoryService service;

    public CategoryResource(CategoryService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAll(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id){
        Category u = service.findById(id);

        if (u != null){
            return ResponseEntity.ok().body(service.findById(id));
        } else {
            return ResponseEntity.notFound().build();
        }

    }
}
