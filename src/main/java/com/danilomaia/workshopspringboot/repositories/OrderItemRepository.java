package com.danilomaia.workshopspringboot.repositories;

import com.danilomaia.workshopspringboot.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
