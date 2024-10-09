package com.bookly.services;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.bookly.dto.ApiResponse;
import com.bookly.entities.Book;
import com.bookly.entities.User;


public interface ImageHandlingService {
	ApiResponse uploadBookImage(Long bookId, MultipartFile image) throws IOException;
	ApiResponse uploadUserImage(Long userId, MultipartFile image) throws IOException;
	byte[] serveImage(Long bookId) throws IOException;
	
	void uploadImage(Book book, MultipartFile image) throws IOException;
	void uploadImage(User user, MultipartFile image) throws IOException;
}
