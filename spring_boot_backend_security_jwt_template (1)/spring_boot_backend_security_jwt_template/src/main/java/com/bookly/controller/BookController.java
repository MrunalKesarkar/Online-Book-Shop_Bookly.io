package com.bookly.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.bookly.dto.BookDTO;
import com.bookly.services.BookService;
import com.bookly.services.ImageHandlingService;


@RestController
@Validated
@RequestMapping("/books")
@CrossOrigin(origins = "*")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	
	
	 @PostMapping("/{categoryId}")
	    public ResponseEntity<?> addNewBook(
	            @ModelAttribute @Valid BookDTO dto,
	            @RequestParam("file") MultipartFile image,
	            @PathVariable Long categoryId) throws IOException {
		return ResponseEntity.status(HttpStatus.CREATED).body(bookService.addNewBookWithImage(dto, image, categoryId));
	}
	
	@GetMapping(value = "/{categoryId}")
	public ResponseEntity<?> getAllBooksByCategory(@PathVariable Long categoryId){
		return ResponseEntity.ok(bookService.getAllBooksByCategory(categoryId));
	}
	
	@GetMapping("/view")
	public ResponseEntity<?> getAllBooks(){
		return ResponseEntity.ok(bookService.getAllBooks());
	}
	
	@DeleteMapping(value = "/{bookId}")
	public ResponseEntity<?> deleteBookById(@PathVariable Long bookId){
		return ResponseEntity.ok(bookService.deleteBookById(bookId));
	}
	
	@GetMapping(value = "/book/{bookId}")
	public ResponseEntity<?> getBookById(@PathVariable Long bookId){
		return ResponseEntity.ok(bookService.getBookById(bookId));
	}
	
	
	@PutMapping(value = "/{bookId}")
	public ResponseEntity<?> updateBookById(@PathVariable Long bookId, @RequestBody BookDTO dto){
		BookDTO book = bookService.getBookById(bookId);
		book.setTitle(dto.getTitle());
		book.setAuthor(dto.getAuthor());
		book.setDescription(dto.getDescription());
		book.setPrice(dto.getPrice());
		book.setPublication(dto.getPublication());
		return ResponseEntity.ok(bookService.updateBook(book));
	}
	
	
}
