package com.bookly.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import com.bookly.entities.Discount;

public interface DiscountDao extends JpaRepository<Discount, Long>
{

	
}
