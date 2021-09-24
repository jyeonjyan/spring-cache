package com.cache.spring.controller;

import com.cache.spring.dto.BookDto;
import com.cache.spring.entity.BookEntity;
import com.cache.spring.service.BookService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@EnableCaching
@Slf4j
public class BookController {
    private final BookService bookService;

    @ApiOperation("서버 상태 확인하기")
    @GetMapping("/hello")
    public String sayHello(){
        return "Hello springboot";
    }

    @ApiOperation("책 추가하기")
    @PostMapping("/save")
    public String saveBook(BookDto bookDto){
        bookService.saveBook(bookDto);
        return "성공적으로 책을 추가했습니다 !";
    }

    @ApiOperation("책 전체 조회하기 - cache 없음")
    @GetMapping("/getAll/nocache/{name}")
    public List<BookEntity> getAllBooks(@PathVariable String name){
        long start = System.currentTimeMillis();
        List<BookEntity> allBook = bookService.getAllBook(name);
        long end = System.currentTimeMillis();

        log.info(name + "의 noCache 수행시간: "+ (end - start));

        return allBook;
    }


    @ApiOperation("책 전체 조회하기 - cache 있음")
    @GetMapping("/getAll/cache/{name}")
    public List<BookEntity> getAllBooksWithCache(@PathVariable String name){
        long start = System.currentTimeMillis();
        List<BookEntity> allBook = bookService.getAllBookCache(name);
        long end = System.currentTimeMillis();

        log.info(name + "의 cache 적용 수행시간: "+ (end - start));

        return allBook;
    }

    @ApiOperation("해당 유저의 cache 리프레시 하기")
    @GetMapping("/getAll/refresh/{name}")
    public String refresh(@PathVariable String name){
        bookService.refresh(name);
        return name + " cache refresh 성공!";
    }

}
