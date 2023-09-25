package com.example.javaCaseStudy.repository;

import com.example.javaCaseStudy.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart,Integer> {

//    @Query("select c.quantity from Cart c where c.prodId = :productId")
//    int findQuantityByProductId(@Param("productId") int productId);
}
