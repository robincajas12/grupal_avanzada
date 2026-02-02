package com.project007.db;

import jakarta.nosql.Column;
import jakarta.nosql.Entity;
import jakarta.nosql.Id;

import java.math.BigDecimal;
import java.util.List;

@Entity
public class Book {

    @Id
    private String isbn;

    @Column
    private String title;

    @Column
    private BigDecimal price;

    @Column
    private List<Author> authors;

    @Column
    private List<Inventory> inventories;

    @Column
    private List<LineItem> lineItems;
}