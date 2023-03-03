package com.danilomaia.workshopspringboot.repositories;

import com.danilomaia.workshopspringboot.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
