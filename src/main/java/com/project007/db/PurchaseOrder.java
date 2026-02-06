package com.project007.db;

import com.project007.converters.StatusConverter;
import jakarta.nosql.Column;
import jakarta.nosql.Convert;
import jakarta.nosql.Entity;
import jakarta.nosql.Id;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class PurchaseOrder {

    @Id
    private String id = UUID.randomUUID().toString();

    @Column
    private LocalDateTime deliveredor;

    @Column
    private LocalDateTime placedon;

    @Column
    private Integer total;

    @Column
    @Convert(StatusConverter.class)
    private Status status;

}
