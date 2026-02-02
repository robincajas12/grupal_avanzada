package com.project007.db;

import jakarta.nosql.Column;
import jakarta.nosql.Entity;
import jakarta.nosql.Id;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class PurchaseOrder {

    @Id
    private Long id;

    enum Status{
        A, B, C
    }

    @Column
    private Integer total;

    @Column
    private Status status;

    @Column
    private LocalDateTime placedOn;

    @Column
    private LocalDateTime deliveredOn;

    @Column
    private List<LineItem> items;

    @Column
    private Customer customer;
}
