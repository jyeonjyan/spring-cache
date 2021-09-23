package com.cache.spring.repository;

import com.cache.spring.entity.BookEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepositoryImpl implements BookRepositoryCustom{

    @Override
    public List<BookEntity> findAllByNoCache() {
        return null;
    }

    @Override
    public List<BookEntity> findAllByCache() {
        return null;
    }

    @Override
    public void refresh() {

    }
}
