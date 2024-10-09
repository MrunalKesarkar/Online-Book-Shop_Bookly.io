package com.bookly.services;



import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookly.custom_exceptions.ResourceNotFoundException;
import com.bookly.dao.BookDao;
import com.bookly.dao.BookReviewDao;
import com.bookly.dao.UserDao;
import com.bookly.dto.ApiResponse;
import com.bookly.dto.BookReviewDTO;
import com.bookly.entities.Book;
import com.bookly.entities.BookReview;
import com.bookly.entities.User;

@Service
@Transactional
public class BookReviewServiceImpl implements BookReviewService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private BookDao bookDao;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private BookReviewDao bookReviewDao;
	
	@Override
	public ApiResponse addBookReview(BookReviewDTO dto,Long bookId, Long userId) {
		User user = userDao.findById(userId).orElseThrow(()-> new ResourceNotFoundException("Invalid User Id"));
		Book book = bookDao.findById(bookId).orElseThrow(()-> new ResourceNotFoundException("Invalid Book Id"));
		BookReview bookReview = mapper.map(dto, BookReview.class);
		bookReview.setUser(user);
		bookReview.setBook(book);
		bookReviewDao.save(bookReview);
		return new ApiResponse("Book Review Added Successfully");
	}

	@Override
	public ApiResponse deleteBookReview(Long bookReviewId) {
		BookReview bookReview = bookReviewDao.findById(bookReviewId).orElseThrow(()-> new ResourceNotFoundException("Invalid BookReviewId"));
		bookReviewDao.delete(bookReview);
		return new ApiResponse("Book Review Deleted Successfully");
	}
	
	

	
}
