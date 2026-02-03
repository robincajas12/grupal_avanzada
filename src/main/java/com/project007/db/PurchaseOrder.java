package com.project007.db;

import jakarta.nosql.Column;
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

    enum Status{
        ESTADO1, ESTADO2

    }

    @Id
    private String id;

    @Column
    private Integer total;

    @Column
    private Status status; // Asegúrate de que el Enum esté accesible

    // Relación hacia Customer
    @Column("ORDERED_BY")
    private Customer customer;

    // Relación hacia los items de la orden
    @Column("CONTAINS")
    private List<LineItem> items;
}
