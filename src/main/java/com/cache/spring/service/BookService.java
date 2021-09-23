package com.cache.spring.service;

import com.cache.spring.dto.BookDto;
import com.cache.spring.entity.BookEntity;
import com.cache.spring.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public BookEntity saveBook(BookDto bookDto){
        return bookRepository.save(bookDto.toEntity());
    }

    public List<BookEntity> getAllBook(String name){
        slowQuery(2000);
        List<BookEntity> bookEntities = bookRepository.findAll();
        log.info("{}의 noCache 처리 완료", name);
        return bookEntities;
    }

    @Cacheable(value = "getAllBooksCache", key = "#name")
    public List<BookEntity> getAllBookCache(String name){
        slowQuery(2000);
        List<BookEntity> bookEntities = bookRepository.findAll();
        log.info("{}의 cache 처리 완료", name);
        return bookEntities;
    }

    @CacheEvict(value = "getAllBooksCache", key = "#name")
    public String refresh(String name){
        return name + " 의 cache clear!";
    }

    private void slowQuery(long seconds){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e){
            throw new IllegalStateException(e);
        }
    }
}
