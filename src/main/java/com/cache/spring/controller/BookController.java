package com.cache.spring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BookController {
    @GetMapping("/hello")
    public String sayHello(){
        return "Hello springboot";
    }
}
