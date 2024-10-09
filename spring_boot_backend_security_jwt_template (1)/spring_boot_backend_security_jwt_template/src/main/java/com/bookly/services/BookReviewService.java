package com.bookly.services;

import com.bookly.dto.ApiResponse;
import com.bookly.dto.BookReviewDTO;

public interface BookReviewService {
	ApiResponse addBookReview(BookReviewDTO dto, Long bookId, Long userId); 
	ApiResponse deleteBookReview(Long bookReviewId);
}
