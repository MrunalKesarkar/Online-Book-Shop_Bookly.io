package com.bookly.services;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.bookly.dto.ApiResponse;
import com.bookly.dto.BookDTO;

public interface BookService {
	List<BookDTO> getAllBooksByCategory(Long CategoryId);
	
	ApiResponse deleteBookById(Long BookId);
	
	BookDTO getBookById(Long bookId);
	
	BookDTO addNewBookWithImage(BookDTO dto, MultipartFile image , Long CategoryId ) throws IOException ;
	
	BookDTO updateBook(BookDTO dto);

	List<BookDTO> getAllBooks();
}
