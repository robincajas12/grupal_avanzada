package com.project007.db;

import jakarta.nosql.Column;
import jakarta.nosql.Entity;
import jakarta.nosql.Id;
import lombok.*;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Inventory {
    @Id
    private String bookIsbn = UUID.randomUUID().toString();

    @Column
    private Long sold;

    @Column
    private Integer supplied;

    @Column
    private Integer version;
}
