package com.example.javaCaseStudy.repository;

import com.example.javaCaseStudy.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, Integer> {
}
