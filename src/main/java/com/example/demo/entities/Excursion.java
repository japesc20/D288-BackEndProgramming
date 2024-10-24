package com.example.demo.entities;


import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "excursions")
@Data

public class Excursion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    // Each column from table 'excursions' from the Mysql database & UML diagram
    @Column (name = "excursion_id")
    private Long id;

    @Column (name = "excursion_title")
    private String excursion_title;

    @Column (name = "excursion_price")
    private BigDecimal excursion_price;

    @Column (name = "image_url")
    private String image_url;

    @Column (name = "create_date")
    private Date create_date;

    @Column (name = "last_update")
    private Date last_update;

    @ManyToOne
    @JoinColumn (name = "vacation_id")
    private Vacation vacation;

    @ManyToMany (cascade = CascadeType.ALL, mappedBy = "excursions")
    private Set<CartItem> cartItems;

    public Excursion() {

    };
}
