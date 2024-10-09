package com.bookly.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import com.bookly.custom_exceptions.ResourceNotFoundException;
import com.bookly.dao.BookDao;
import com.bookly.dao.CategoryDao;
import com.bookly.dto.ApiResponse;
import com.bookly.dto.BookDTO;
import com.bookly.entities.Book;
import com.bookly.entities.Category;


@Service
@Transactional
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookDao;
	
	@Autowired 
	private CategoryDao categoryDao;
	
	@Autowired 
	private ModelMapper mapper;
	
	@Autowired
	private ImageHandlingService imageHandlingService;
	
	@Override
	public ApiResponse deleteBookById(Long BookId) {
		Book book = bookDao.findById(BookId).orElseThrow(()-> new ResourceNotFoundException("Invalid Book Id"));
		bookDao.delete(book);
		return new ApiResponse("Book Deleted With ID - "+ book.getBookId());
	}

	

	@Override
	public BookDTO getBookById(Long bookId) {
		Book book = bookDao.findById(bookId).orElseThrow(()-> new ResourceNotFoundException("Invalid Book Id"));
		return mapper.map(book, BookDTO.class);
	}

	@Override
	public BookDTO updateBook(BookDTO dto) {
		Book book = mapper.map(dto, Book.class);
		Book updatedBook = bookDao.save(book);
		return mapper.map(updatedBook, BookDTO.class);
	}

	@Override
	public List<BookDTO> getAllBooksByCategory(Long CategoryId) {
		List<Book> bookList = bookDao.findByCategory(CategoryId);
		List<BookDTO> bookDtoList = new ArrayList<>();
		for (Book book : bookList) {
			BookDTO dto = mapper.map(book, BookDTO.class);
			bookDtoList.add(dto);
		}
		return bookDtoList;
	}
	
	@Override
	public List<BookDTO> getAllBooks() {
		List<Book> bookList = bookDao.findAll();
		List<BookDTO> bookDtoList = new ArrayList<>();
		for (Book book : bookList) {
			BookDTO dto = mapper.map(book, BookDTO.class);
			bookDtoList.add(dto);
		}
		return bookDtoList;
	}
	
	@Override
	public BookDTO addNewBookWithImage(BookDTO dto, MultipartFile image, Long categoryId) throws IOException {

		
			Category category = categoryDao.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Invalid Category Id"));
			
			Book BookEntity = mapper.map(dto, Book.class);
			BookEntity.setCategory(category);
			
			imageHandlingService.uploadImage(BookEntity, image);
			
			Book persistentBook = bookDao.save(BookEntity);

			return mapper.map(persistentBook, BookDTO.class);

		
	}

}
