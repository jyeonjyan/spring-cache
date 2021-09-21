package com.cache.spring.controller;

import com.cache.spring.dto.BookDto;
import com.cache.spring.service.BookService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @ApiOperation("서버 상태 확인하기")
    @GetMapping("/hello")
    public String sayHello(){
        return "Hello springboot";
    }

    @ApiOperation("책 추가하기")
    @PostMapping("/save")
    public void saveBook(BookDto bookDto){
        bookService.saveBook(bookDto);
    }
}
