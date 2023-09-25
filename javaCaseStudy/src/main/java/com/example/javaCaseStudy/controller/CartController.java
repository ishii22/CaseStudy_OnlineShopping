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

    @CrossOrigin
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Cart>> getAllCartElements(){
        return new ResponseEntity<>(cartService.getAllCartElements(),HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/getTotalAmount")
    public ResponseEntity<Double> getTotalAmount(){
        return new ResponseEntity<>(cartService.getTotalAmount(),HttpStatus.OK);
    }


    @CrossOrigin
    @PostMapping(consumes = "application/json")
    public HttpStatus addProductToCart(@RequestBody Cart cart){
        if(cartService.addOrUpdateProductToCart(cart))
            return HttpStatus.OK;
        return HttpStatus.NOT_MODIFIED;
    }

    @CrossOrigin
    @PutMapping(value = "/increase/{productId}")
    public HttpStatus increaseProductQuantityInCart(@PathVariable int productId){
        int quantity = cartService.findQuantityByProductId(productId);
        quantity++;
        if(cartService.addOrUpdateProductToCart(new Cart(productId,quantity)))
            return HttpStatus.OK;
        return HttpStatus.NOT_MODIFIED;
    }

    @CrossOrigin
    @PutMapping(value = "/decrease/{productId}")
    public HttpStatus decreaseProductQuantityInCart(@PathVariable int productId){
        int quantity = cartService.findQuantityByProductId(productId);
        if(quantity>0)
            quantity--;
        // delete from cart when 0
        if(cartService.addOrUpdateProductToCart(new Cart(productId,quantity)))
            return HttpStatus.OK;
        return HttpStatus.NOT_MODIFIED;
    }

    @CrossOrigin
    @DeleteMapping(value = "/{productId}")
    public HttpStatus removeProductFromCartById(@PathVariable int productId){
        if(cartService.removeProductFromCart(productId))
            return HttpStatus.OK;
        return HttpStatus.NOT_MODIFIED;
    }

    @CrossOrigin
    @DeleteMapping
    public HttpStatus emptyCart(){
        if(cartService.emptyCart())
            return HttpStatus.OK;
        return HttpStatus.NOT_MODIFIED;
    }

}
