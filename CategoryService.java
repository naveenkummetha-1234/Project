package com.example.demo.Service;


import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.Category;
import com.example.demo.Repository.CategoryRepository;

@Service
	public class CategoryService {

	    @Autowired
	    private CategoryRepository categoryRepository;

	    public Page <Category>getAllCategories(Pageable pageable) {
	        return categoryRepository.findAll(pageable);
	    }

	    public Category createCategory(Category category) {
	        return categoryRepository.save(category);
	    }

	    public Optional<Category> getCategoryById(Long id) {
	        return categoryRepository.findById(id);
	    }

	    public Category updateCategory(Long id, Category categoryDetails) {
	        Category category = categoryRepository.findById(id).orElseThrow();
	        category.setName(categoryDetails.getName());
	        return categoryRepository.save(category);
	    }

	    public void deleteCategory(Long id) {
	        categoryRepository.deleteById(id);
	    }
	}


