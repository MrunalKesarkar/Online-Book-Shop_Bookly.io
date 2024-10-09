package com.bookly.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookly.custom_exceptions.ResourceNotFoundException;
import com.bookly.dao.CategoryDao;
import com.bookly.dto.ApiResponse;
import com.bookly.dto.CategoryDTO;
import com.bookly.entities.Category;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private ModelMapper mapper;
	
	
	@Override
	public CategoryDTO addCategory(CategoryDTO dto) {
		Category newCategory = mapper.map(dto, Category.class);
		Category persistentCategory = categoryDao.save(newCategory);
		return mapper.map(persistentCategory, CategoryDTO.class);
	}

	@Override
	public ApiResponse deleteCategory(Long categoryId) {
		Category category = categoryDao.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Invalid CategoryId"));
		categoryDao.delete(category);
		return new ApiResponse("Category Deleted with id- "+category.getCategoryId());
	}

	@Override
	public CategoryDTO getCategoryById(Long categoryId) {
		Category category = categoryDao.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Invalid CategoryId"));
		return mapper.map(category, CategoryDTO.class);
	}

	@Override
	public List<CategoryDTO> getAllCategories() {
		List<Category> categoryList = categoryDao.findAll();
		List<CategoryDTO> categoryDtoList = new ArrayList<>();
		for (Category category : categoryList) {
			CategoryDTO dto = mapper.map(category, CategoryDTO.class);
			categoryDtoList.add(dto);
		}
		return categoryDtoList;
	}

	@Override
	public CategoryDTO updateCategoryById(Long categoryId , CategoryDTO dto) {
		Category category = categoryDao.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Invalid Category Id"));
		category.setCategoryName(dto.getCategoryName());
		category.setDescription(dto.getDescription());
		categoryDao.save(category);
		return mapper.map(category, CategoryDTO.class);
	}
	
	
}
