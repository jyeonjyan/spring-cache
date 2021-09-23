package com.cache.spring.service;

import com.cache.spring.dto.BookDto;
import com.cache.spring.entity.BookEntity;
import com.cache.spring.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public BookEntity saveBook(BookDto bookDto){
        return bookRepository.save(bookDto.toEntity());
    }

    public List<BookEntity> getAllBook(){
        return bookRepository.findAllByNoCache();
    }

    public List<BookEntity> getAllBookCache(){
        return bookRepository.findAllByCache();
    }

    public String refresh(){
        bookRepository.refresh();
        return "clear cache was successful!";
    }
}
