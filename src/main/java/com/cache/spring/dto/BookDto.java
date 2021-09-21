package com.cache.spring.dto;

import com.cache.spring.entity.BookEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
    private String bookName;
    private String author;
    private String publisher;

    public BookEntity toEntity(){
        return BookEntity.builder()
                .bookName(this.bookName)
                .author(this.author)
                .publisher(this.publisher)
                .build();
    }
}
