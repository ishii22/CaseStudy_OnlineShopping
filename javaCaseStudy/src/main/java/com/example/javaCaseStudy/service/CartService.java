package com.example.javaCaseStudy.service;

import com.example.javaCaseStudy.entity.Cart;
import com.example.javaCaseStudy.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    CartRepository cartRepository;

    @Transactional(readOnly = true)
    public List<Cart> getAllCartElements(){
        return cartRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Cart getCartItemById(int productId){
        Optional<Cart> oc = cartRepository.findById(productId);
        if (oc.isPresent())
            return oc.get();
        return null;
    }

    @Transactional(readOnly = true)
    public double getTotalAmount(){
        List<Cart> cart = getAllCartElements();
        double amount = 0.0;
        for (Cart item:cart) {
            amount += item.getQuantity() * item.getProduct().getProductPrice();
        }
        return amount;
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
    @Transactional
    public boolean emptyCart(){
        cartRepository.deleteAll();
        long count = cartRepository.count();
        return count==0;
    }

    @Transactional
    public int findQuantityByProductId(int productId){
        int quantity = 0;
        quantity = getCartItemById(productId).getQuantity();
        return quantity;
    }
}
