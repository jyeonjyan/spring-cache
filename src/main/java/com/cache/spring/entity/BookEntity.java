package com.cache.spring.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter @Builder
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
