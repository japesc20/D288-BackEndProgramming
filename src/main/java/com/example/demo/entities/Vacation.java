package com.example.demo.entities;


import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "vacations")
@Data
public class Vacation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "vacation_id")
    private Long vacation_id;

    @Column (name = "create_date")
    private Date create_date;

    @Column (name = "description")
    private String description;

    @Column (name = "image_url")
    private String image_url;

    @Column (name = "last_update")
    private Date last_update;

    @Column (name = "travel_fare_price")
    private BigDecimal travel_fare_price;

    @Column (name = "vacation_title")
    private String vacation_title;

}
