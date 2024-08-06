package com.movieguru.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping("/")
    public String getWelcomeMessage() {
        return "Welcome to MovieGuru API. Access Swagger for more.";
    }
}
