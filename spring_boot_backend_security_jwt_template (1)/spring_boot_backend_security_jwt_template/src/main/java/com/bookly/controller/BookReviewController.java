package com.bookly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookly.dto.BookReviewDTO;
import com.bookly.services.BookReviewService;

@RestController
@RequestMapping("/bookReviews")
@CrossOrigin(origins = "*")
public class BookReviewController {

	@Autowired
	private BookReviewService bookReviewService;
	
	@PostMapping(value = "/{bookId}/{userId}")
	public ResponseEntity<?> addBookReview(@RequestBody BookReviewDTO dto, @PathVariable Long bookId, @PathVariable Long userId){
		return ResponseEntity.status(HttpStatus.CREATED).body(bookReviewService.addBookReview(dto, bookId, userId));
	}
	
	@DeleteMapping(value = "/{bookReviewId}")
	public ResponseEntity<?> deleteBookReview(@PathVariable Long bookReviewId){
		return ResponseEntity.ok(bookReviewService.deleteBookReview(bookReviewId));
	}
}
