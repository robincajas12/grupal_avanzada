package com.project007.db;

import com.project007.converters.BigDecimalConverter;
import jakarta.nosql.Column;
import jakarta.nosql.Convert;
import jakarta.nosql.Entity;
import jakarta.nosql.Id;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Book {
    @Id
    private String isbn = UUID.randomUUID().toString();

    @Column
    private String title;

    @Column
    @Convert(BigDecimalConverter.class)
    private BigDecimal price;

    @Column Integer version;

}