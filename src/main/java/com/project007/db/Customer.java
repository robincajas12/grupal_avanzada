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
@Entity
@ToString
public class Customer {
    @Id
    private String id = UUID.randomUUID().toString();

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private Integer version;
}
