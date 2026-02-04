package com.project007.db;

import jakarta.nosql.Column;
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
public class Inventory {
    @Id
    private String bookIsbn;

    @Column
    private Long sold;

    @Column
    private Integer supplied;

    @Column
    private Integer version;
}
