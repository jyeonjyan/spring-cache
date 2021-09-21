package com.cache.spring.controller;

import com.cache.spring.dto.BookDto;
import com.cache.spring.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello springboot";
    }

    @PostMapping("/save")
    public void saveBook(BookDto bookDto){
        bookService.saveBook(bookDto);
    }
}
