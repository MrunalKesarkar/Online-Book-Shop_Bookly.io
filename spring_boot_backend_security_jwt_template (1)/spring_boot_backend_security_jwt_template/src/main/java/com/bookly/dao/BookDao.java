package com.bookly.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bookly.entities.Book;

public interface BookDao extends JpaRepository<Book ,Long>{
	
	List<Book> findByCategory(Long categoryId);
	
	
}
