package com.example.demo.entities;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "vacations")
@Data

public class Vacation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    // Each column from table 'vacations' from the Mysql database & UML diagram
    @Column (name = "vacation_id")
    private Long id;

    @Column (name = "vacation_title")
    private String vacation_title;

    @Column (name = "description")
    private String description;

    @Column (name = "travel_fare_price")
    private BigDecimal travel_price;

    @Column (name = "image_url")
    private String image_url;

    @Column (name = "create_date")
    private Date create_date;

    @Column (name = "last_update")
    private Date last_update;

    @OneToMany (cascade = CascadeType.ALL, mappedBy = "vacation")
    private Set<Excursion> excursions;


    public Vacation() {

    };
}
