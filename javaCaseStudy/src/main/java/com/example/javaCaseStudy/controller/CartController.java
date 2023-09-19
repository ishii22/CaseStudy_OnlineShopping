package com.example.javaCaseStudy.controller;

import com.example.javaCaseStudy.entity.Cart;
import com.example.javaCaseStudy.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/cart")
@RestController
public class CartController {

    @Autowired
    CartService cartService;

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Cart>> getAllCartElements(){
        return new ResponseEntity<>(cartService.getAllCartElements(),HttpStatus.OK);
    }

    @PostMapping(consumes = "application/json")
    public HttpStatus addProductToCart(@RequestBody Cart cart){
        if(cartService.addOrUpdateProductToCart(cart))
            return HttpStatus.OK;
        return HttpStatus.NOT_MODIFIED;
    }

    @PutMapping(consumes = "application/json")
    public HttpStatus updateProductQuantityInCart(@RequestBody Cart cart){
        if(cartService.addOrUpdateProductToCart(cart))
            return HttpStatus.OK;
        return HttpStatus.NOT_MODIFIED;
    }

    @DeleteMapping(value = "/{productId}")
    public HttpStatus removeProductFromCart(@PathVariable int productId){
        if(cartService.removeProductFromCart(productId))
            return HttpStatus.OK;
        return HttpStatus.NOT_MODIFIED;
    }

}
