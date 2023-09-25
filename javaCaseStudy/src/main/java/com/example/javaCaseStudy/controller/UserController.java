package com.example.javaCaseStudy.controller;

import com.example.javaCaseStudy.entity.User;
import com.example.javaCaseStudy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @CrossOrigin
    @GetMapping(value = "/{username}")
    public ResponseEntity<User> login(@PathVariable String username) {
        return new ResponseEntity<>(userService.getUserByUsername(username),HttpStatus.OK);
//        if (userService.getUserByUsername(username))
//            return new ResponseEntity<>(userService.getUserByUsername(username.getUsername()),HttpStatus.OK);
//        throw new RuntimeException("User does not exist");
//        return HttpStatus.NOT_FOUND;
            // Authentication successful, store user information in the session
//            session.setAttribute("username", username);
//            return "redirect:/home"; // Redirect to the home page or another secured page
//        } else {
//            // Authentication failed, redirect back to the login page with an error message
//            return "redirect:/login?error=true";
//        }
    }
}
