package com.example.javaCaseStudy.service;

import com.example.javaCaseStudy.entity.Cart;
import com.example.javaCaseStudy.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CartService {

    @Autowired
    CartRepository cartRepository;

    @Transactional(readOnly = true)
    public List<Cart> getAllCartElements(){
        return cartRepository.findAll();
    }

    @Transactional
    public boolean addOrUpdateProductToCart(Cart cart){
        Cart c = cartRepository.save(cart);
        return c!= null;
    }

    @Transactional
    public boolean removeProductFromCart(int productId){
        long count = cartRepository.count();
        cartRepository.deleteById(productId);
        return count>cartRepository.count();
    }
}
