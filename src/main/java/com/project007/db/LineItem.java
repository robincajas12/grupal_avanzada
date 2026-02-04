package com.project007.db;

import jakarta.nosql.Column;
import jakarta.nosql.Embeddable;
import jakarta.nosql.Entity;
import jakarta.nosql.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class LineItem {

    @Id("order_id")
    private String id;

    @Column
    private Integer quantity;

    @Column
    private Integer idx;

//    // Relación hacia el libro (Muchos items pueden apuntar al mismo libro)
//    @Column("REFERENCES_BOOK")
//    private Book book;
}
