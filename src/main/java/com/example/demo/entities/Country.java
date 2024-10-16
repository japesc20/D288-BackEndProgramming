package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "countries")
@Data

public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "country_id")
    private Long country_id;

    @Column (name = "country")
    private String country;

    @Column (name = "create_date")
    private Date create_date;

    @Column (name = "last_update")
    private Date last_update;


}
