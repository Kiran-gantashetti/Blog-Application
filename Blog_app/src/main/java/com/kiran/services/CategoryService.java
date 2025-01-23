package com.kiran.services;

import java.util.List;

import com.kiran.payloads.CategoryDto;

public interface CategoryService {
	
	// create 
	 CategoryDto createCategory(CategoryDto categoryDto);
      
    // update 
	 CategoryDto updateCategory(CategoryDto categoryDto , Integer categoryId);
	//delete
	 void deleteCategory(Integer categoryId);
	 
	 //get
	  CategoryDto getCategory(Integer categoryId);
	  
	  List<CategoryDto> getCategories();

	//CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);
}
