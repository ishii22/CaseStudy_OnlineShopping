package com.example.javaCaseStudy.controller;

import com.example.javaCaseStudy.entity.Cart;
import com.example.javaCaseStudy.entity.Orders;
import com.example.javaCaseStudy.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @CrossOrigin
    @PostMapping(consumes = "application/json")
    public HttpStatus addProductToCart(@RequestBody Orders order){
        if(orderService.addOrUpdateOrders(order))
            return HttpStatus.OK;
        return HttpStatus.NOT_MODIFIED;
    }
}
