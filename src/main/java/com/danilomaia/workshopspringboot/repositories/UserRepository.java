package com.danilomaia.workshopspringboot.repositories;

import com.danilomaia.workshopspringboot.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, Long> {

}
