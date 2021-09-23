package com.cache.spring.repository;

import com.cache.spring.entity.BookEntity;

import java.util.List;

public interface BookRepositoryCustom {
    List<BookEntity> findAllByNoCache();
    List<BookEntity> findAllByCache();
    void refresh();
}
