package com.example.javaCaseStudy.controller;

import com.example.javaCaseStudy.entity.Product;
import com.example.javaCaseStudy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/products")
@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @CrossOrigin
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Product>> getAllProducts(){
        return new ResponseEntity<List<Product>>(productService.getAllProducts(),HttpStatus.OK);

    }
    @ExceptionHandler(RuntimeException.class)
    public HttpStatus productNotFound(){
        return HttpStatus.NOT_FOUND;
    }
}
