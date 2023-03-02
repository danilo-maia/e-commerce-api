package com.danilomaia.workshopspringboot.resources;

import com.danilomaia.workshopspringboot.entities.User;
import com.danilomaia.workshopspringboot.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")

public class UserResource {

    private final UserService service;

    public UserResource(UserService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        User u = service.findById(id);

        if (u != null){
            return ResponseEntity.ok().body(service.findById(id));
        } else {
            return ResponseEntity.notFound().build();
        }

    }
}
