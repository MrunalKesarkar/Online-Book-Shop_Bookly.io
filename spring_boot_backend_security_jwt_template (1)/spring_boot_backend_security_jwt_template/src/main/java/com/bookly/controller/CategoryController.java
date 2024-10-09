package com.bookly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookly.dto.CategoryDTO;
import com.bookly.services.CategoryService;

@RestController
@RequestMapping("/categories")
@CrossOrigin(origins = "*")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/view")
	public ResponseEntity<?> getAllCategories(){
		return ResponseEntity.ok(categoryService.getAllCategories());
	}
	
	@GetMapping(value = "/{cateId}")
	public ResponseEntity<?> getCategoryById(@PathVariable Long cateId){
		return ResponseEntity.ok(categoryService.getCategoryById(cateId));
	}
	
	@PostMapping
	public ResponseEntity<?> addNewCategory(@RequestBody CategoryDTO dto){
		return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.addCategory(dto));
	}
	
	@DeleteMapping(value = "/{cateId}")
	public ResponseEntity<?> deleteCategory(@PathVariable Long cateId){
		return ResponseEntity.ok(categoryService.deleteCategory(cateId));
	}
	
	@PutMapping(value = "/{categoryId}")
	public ResponseEntity<?> updateCategory(@PathVariable Long categoryId, @RequestBody CategoryDTO dto){
		return ResponseEntity.ok(categoryService.updateCategoryById(categoryId, dto));
	}
}
