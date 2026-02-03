package com.project007.db;

import jakarta.nosql.Column;
import jakarta.nosql.Entity;
import jakarta.nosql.Id;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    private String isbn;

    @Column
    private String title;

    @Column
    private Double price;

    // Muchos a Muchos: La flecha sale de Book hacia Author
    @Column("WRITTEN_BY")
    private List<Author> authors;

    // Uno a Uno: La flecha sale de Book hacia Inventory
    @Column("HAS_STOCK")
    private Inventory inventory;
}