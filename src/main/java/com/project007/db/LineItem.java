package com.project007.db;

import jakarta.nosql.Column;
import jakarta.nosql.Embeddable;
import jakarta.nosql.Entity;
import jakarta.nosql.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class LineItem {

    @Id
    private String id= UUID.randomUUID().toString();

    @Column
    private Integer quantity;

    @Column
    private Integer idx;

}
