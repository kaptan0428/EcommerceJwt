package com.example.ecommerceJwt.controller;

import com.example.ecommerceJwt.model.User;
import com.example.ecommerceJwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public String registerUserEndpoint(@RequestBody User user){
        return userService.registerUser(user);
    }

    @GetMapping("/login")
    public String loginUserEndpoint(@RequestBody User user){
        return userService.loginUser(user.getUserName(), user.getPassword1());
    }
}
