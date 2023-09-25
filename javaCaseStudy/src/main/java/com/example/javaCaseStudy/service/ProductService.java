package com.example.javaCaseStudy.service;

import com.example.javaCaseStudy.entity.Product;
import com.example.javaCaseStudy.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Product> getProductByCategory(String category){
        return productRepository.findByProductCategoryContaining(category);
    }
}
