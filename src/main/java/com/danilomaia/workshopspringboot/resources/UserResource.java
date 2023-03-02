package com.danilomaia.workshopspringboot.resources;

import com.danilomaia.workshopspringboot.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")

public class UserResource {

    @GetMapping
    public ResponseEntity<User> getAll(){
        User u = new User(1L, "Bob Brown", "bob@gmail.com", "98999999999", "123456");
        return ResponseEntity.ok().body(u);
    }
}
