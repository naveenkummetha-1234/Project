package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entities.Product;

public interface ProductRepository extends JpaRepository<Product,Long>{

}
