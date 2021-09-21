package com.cache.spring.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookIdx;
    @Column
    private String author;
    @Column
    private String publisher;
}
