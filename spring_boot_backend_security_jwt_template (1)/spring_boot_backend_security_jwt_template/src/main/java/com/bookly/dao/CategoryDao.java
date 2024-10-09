package com.bookly.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookly.entities.Category;

public interface CategoryDao extends JpaRepository<Category, Long>{
	
}
