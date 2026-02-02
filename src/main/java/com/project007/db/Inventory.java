package com.project007.db;

import jakarta.nosql.Column;
import jakarta.nosql.Entity;
import jakarta.nosql.Id;

@Entity
public class Inventory{

    @Id
    private String isbn;

    @Column
    private Integer sold;

    @Column
    private Integer supplied;

    @Column
    private Integer version;

    @Column
    private Book book;
}
