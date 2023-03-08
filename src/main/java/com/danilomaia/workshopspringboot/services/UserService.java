package com.danilomaia.workshopspringboot.services;

import com.danilomaia.workshopspringboot.entities.User;
import com.danilomaia.workshopspringboot.repositories.UserRepository;
import com.danilomaia.workshopspringboot.services.exceptions.DatabaseException;
import com.danilomaia.workshopspringboot.services.exceptions.ResourceNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User obj){
        return repository.save(obj);
    }

    public void delete(Long id){
        if (repository.findById(id).isEmpty())
            throw new ResourceNotFoundException(id);

        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }

    public User update(Long id, User obj){
        User entity = repository.getReferenceById(id);
        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(User entity, User obj) {
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
        entity.setName(obj.getName());
    }
}
