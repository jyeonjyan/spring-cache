package com.cache.spring.service;

import com.cache.spring.dto.BookDto;
import com.cache.spring.entity.BookEntity;
import com.cache.spring.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public BookEntity saveBook(BookDto bookDto){
        return bookRepository.save(bookDto.toEntity());
    }
}
