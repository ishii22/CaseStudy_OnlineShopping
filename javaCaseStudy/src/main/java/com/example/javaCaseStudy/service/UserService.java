package com.example.javaCaseStudy.service;

import com.example.javaCaseStudy.entity.Cart;
import com.example.javaCaseStudy.entity.User;
import com.example.javaCaseStudy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User getUserByUsername(String username) {
        Optional<User> ou = userRepository.findById(username);
        if (ou.isPresent())
            return ou.get();
        return null;
    }

    public boolean isValidUser(User user) {
        User u = getUserByUsername(user.getUsername());
        return u != null && u.getPassword().equals(user.getPassword());
    }
}
