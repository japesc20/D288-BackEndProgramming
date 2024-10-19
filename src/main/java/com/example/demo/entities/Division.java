package com.example.demo.entities;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "divisions")
@Data

public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "division_id")
    private Long id;

    @Column (name = "division")
    private String division_name;

    @Column (name = "create_date")
    private Date create_date;

    @Column (name = "last_update")
    private Date last_update;

    @ManyToOne
    @Column (name = "country_id")
    private Country country;

    @Column (name = "country_id")
    private Long country_id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "division")
    private Set<Customer> customers;

    public Division() {

    };
}