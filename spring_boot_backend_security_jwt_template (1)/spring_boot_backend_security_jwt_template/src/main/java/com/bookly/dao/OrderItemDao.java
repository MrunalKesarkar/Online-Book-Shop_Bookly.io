package com.bookly.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookly.entities.OrderItem;

public interface OrderItemDao extends JpaRepository<OrderItem, Long>{

}
