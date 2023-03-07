package com.danilomaia.workshopspringboot.services;

import com.danilomaia.workshopspringboot.entities.User;
import com.danilomaia.workshopspringboot.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(Long id){
        Optional<User> obj = repository.findById(id);
        return obj.orElse(null);
    }

    public User insert(User obj){
        return repository.save(obj);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}
