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
    @Column (name = "vacation_id")
    private Vacation vacation;

    @OneToMany (cascade = CascadeType.ALL, mappedBy = "excursion")
    private Set<CartItem> cartItems;

    public Excursion() {

    };
}
