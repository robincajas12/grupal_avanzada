package com.project007.db;

import jakarta.nosql.Column;
import jakarta.nosql.Entity;
import jakarta.nosql.Id;
import lombok.*;

import java.util.UUID;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Author {
    @Id
    private String id = UUID.randomUUID().toString();

    @Column
    private String name;

    @Column
    private Integer version;
}
