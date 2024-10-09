package com.bookly.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookly.entities.Order;

public interface OrderDao extends JpaRepository<Order, Long>{

}
