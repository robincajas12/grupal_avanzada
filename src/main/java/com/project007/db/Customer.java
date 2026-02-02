package com.project007.db;

import jakarta.nosql.Column;
import jakarta.nosql.Entity;
import jakarta.nosql.Id;

import java.util.List;

@Entity
public class Customer {

    @Id
    private Long id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private Integer version;

    @Column
    private List<PurchaseOrder> orders;
}
