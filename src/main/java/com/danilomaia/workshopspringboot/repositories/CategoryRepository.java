package com.danilomaia.workshopspringboot.repositories;

import com.danilomaia.workshopspringboot.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
