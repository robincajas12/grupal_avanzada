package com.project007.db;

import com.project007.converters.StatusConverter;
import jakarta.nosql.Column;
import jakarta.nosql.Convert;
import jakarta.nosql.Entity;
import jakarta.nosql.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PurchaseOrder {

    @Id
    private String id;

    @Column
    private LocalDateTime deliveredor;

    @Column
    private LocalDateTime placedon;

    @Column
    private Integer total;

    @Column
    @Convert(StatusConverter.class)
    private Status status;

//    // Relación hacia Customer
//    @Column("ORDERED_BY")
//    private Customer customer;
//
//    // Relación hacia los items de la orden
//    @Column("CONTAINS")
//    private List<LineItem> items;
}
