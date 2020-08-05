package com.ruijosecj.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ruijosecj.curso.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
