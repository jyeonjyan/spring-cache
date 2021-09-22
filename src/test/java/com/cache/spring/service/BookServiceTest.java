package com.cache.spring.service;

import com.cache.spring.entity.BookEntity;
import com.cache.spring.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Commit
@Slf4j
class BookServiceTest {

    @Autowired
    private BookService bookService;
    @Autowired
    private BookRepository bookRepository;

    @Test
    public void createBooks(){
        //Given
        List<BookEntity> bookEntities = Stream.generate(
                () -> BookEntity.builder()
                        .bookName("지환이란")
                        .author("jihwan")
                        .publisher("jyeonjyan")
                        .build()
        ).limit(30000).collect(Collectors.toList());

        bookRepository.saveAll(bookEntities);

        //When
        long start = System.currentTimeMillis();
        bookRepository.findAll();
        long end = System.currentTimeMillis();
        log.info("========findAll query execution time: {}", (end-start)/1000.0);

    }
}