package com.example.productsapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/welcome")
public class Welcome {

    @GetMapping
    public String welcome(){
        return "Welcome to Spring Boot API";
    }
}
