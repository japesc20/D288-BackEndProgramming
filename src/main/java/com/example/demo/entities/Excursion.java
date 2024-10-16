package com.example.demo.entities;


import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "excursions")
@Data

public class Excursion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "excursion_id")
    private Long excursion_id;

    @Column (name = "create_date")
    private Date create_date;

    @Column (name = "excursion_price")
    private BigDecimal excursion_price;

    @Column (name = "excursion_title")
    private String excursion_title;

    @Column (name = "image_url")
    private String image_url;

    @Column (name = "last_update")
    private Date last_update;

    @Column (name = "vacation_id")
    private Vacation vacation;
}
