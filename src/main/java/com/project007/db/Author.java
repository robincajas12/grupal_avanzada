package com.project007.db;

import jakarta.nosql.Column;
import jakarta.nosql.Entity;
import jakarta.nosql.Id;

import java.util.List;

@Entity
public class Author {

    @Id
    private Long id;

    @Column
    private String name;

    @Column
    private Integer version;

    @Column
    private List<Book> books;
}
