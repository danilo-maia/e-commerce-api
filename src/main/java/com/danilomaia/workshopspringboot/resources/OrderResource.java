package com.danilomaia.workshopspringboot.resources;

import com.danilomaia.workshopspringboot.entities.Order;
import com.danilomaia.workshopspringboot.services.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")

public class OrderResource {

    private final OrderService service;

    public OrderResource(OrderService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAll(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id){
        Order u = service.findById(id);

        if (u != null){
            return ResponseEntity.ok().body(service.findById(id));
        } else {
            return ResponseEntity.notFound().build();
        }

    }
}
