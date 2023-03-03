package com.danilomaia.workshopspringboot.repositories;

import com.danilomaia.workshopspringboot.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
