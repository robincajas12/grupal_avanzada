package com.project007.db;

import jakarta.nosql.Column;
import jakarta.nosql.Entity;
import jakarta.nosql.Id;

@Entity
public class LineItem {

    @Id
    private Long id;

    @Column
    private Integer quantity;

    @Column
    private Integer idx;

    @Column
    private Book book;

    @Column
    private PurchaseOrder purchaseOrder;
}
