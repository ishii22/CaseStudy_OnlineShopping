package com.example.javaCaseStudy.repository;

import com.example.javaCaseStudy.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
