package com.bookly.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookly.entities.BookReview;

public interface BookReviewDao extends JpaRepository<BookReview, Long>{
	
}