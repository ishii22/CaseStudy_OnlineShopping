package com.example.javaCaseStudy.service;

import com.example.javaCaseStudy.entity.Orders;
import com.example.javaCaseStudy.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Transactional
    public boolean addOrUpdateOrders(Orders order){
        Orders o = orderRepository.save(order);
        return o!= null;
    }
}
