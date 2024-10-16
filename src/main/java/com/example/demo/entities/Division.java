package com.example.demo.entities;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "divisions")
@Data

public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "division_id")
    private Long division_id;

    @Column (name = "division")
    private String division;

    @Column (name = "create_date")
    private Date create_date;

    @Column (name = "last_update")
    private Date last_update;

    @Column (name = "country_id")
    private Country country;
}
