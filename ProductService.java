package com.example.demo.Service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.Product;
import com.example.demo.Repository.ProductRepository;

@Service
	public class ProductService {

	    @Autowired
	    private ProductRepository productRepository;

	    public Page<Product> getAllProducts(Pageable pageable) {
	        return productRepository.findAll(pageable);
	    }

	    public Product createProduct(Product product) {
	        return productRepository.save(product);
	    }

	    public Optional<Product> getProductById(Long id) {
	        return productRepository.findById(id);
	    }

	    public Product updateProduct(Long id, Product productDetails) {
	        Product product = productRepository.findById(id).orElseThrow();
	        product.setName(productDetails.getName());
	      
	       
	        product.setCategory(productDetails.getCategory());
	        return productRepository.save(product);
	    }

	    public void deleteProduct(Long id) {
	        productRepository.deleteById(id);
	    }
	}
	


