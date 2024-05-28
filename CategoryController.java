package com.example.demo.Controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entities.Category;
import com.example.demo.Service.CategoryService;

@RestController
	@RequestMapping("/api/categories")
	public class CategoryController {

	    @Autowired
	    private CategoryService categoryService;

	    @GetMapping
	    public Page<Category> getAllCategories(@RequestParam(defaultValue = "0") int page) {
	        Pageable pageable = PageRequest.of(page, 10);
	        return categoryService.getAllCategories(pageable);
	    }

	    @PostMapping
	    public Category createCategory(@RequestBody Category category) {
	        return categoryService.createCategory(category);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
	        Optional<Category> category = categoryService.getCategoryById(id);
	        return category.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category categoryDetails) {
	        return ResponseEntity.ok(categoryService.updateCategory(id, categoryDetails));
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
	        categoryService.deleteCategory(id);
	        return ResponseEntity.noContent().build();
	    }
	}


