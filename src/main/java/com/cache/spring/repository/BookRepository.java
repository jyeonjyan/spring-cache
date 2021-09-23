package com.cache.spring.repository;

import com.cache.spring.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
    List<BookEntity> findAllByNoCache();

    List<BookEntity> findAllByCache();

    void refresh();
}