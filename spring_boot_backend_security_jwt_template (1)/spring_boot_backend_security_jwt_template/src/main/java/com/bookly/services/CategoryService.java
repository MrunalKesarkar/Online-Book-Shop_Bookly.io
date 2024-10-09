package com.bookly.services;

import java.util.List;

import com.bookly.dto.ApiResponse;
import com.bookly.dto.CategoryDTO;

public interface CategoryService {
	CategoryDTO addCategory(CategoryDTO dto);
	
	ApiResponse deleteCategory(Long categoryId);
	
	CategoryDTO getCategoryById(Long categoryId);
	
	List<CategoryDTO> getAllCategories();
	
	CategoryDTO updateCategoryById(Long categoryId, CategoryDTO dto);
}
