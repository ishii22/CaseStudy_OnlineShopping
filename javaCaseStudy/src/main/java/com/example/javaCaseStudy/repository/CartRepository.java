package com.example.javaCaseStudy.repository;

import com.example.javaCaseStudy.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Integer> {
}
