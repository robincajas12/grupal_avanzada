package com.project007.db;

import jakarta.nosql.Column;
import jakarta.nosql.Convert;
import jakarta.nosql.Entity;
import jakarta.nosql.Id;
import lombok.*;

import java.math.BigDecimal;


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
    @Convert(BigDecimalConverter.class)
    private BigDecimal price;

    @Column Integer version;

}