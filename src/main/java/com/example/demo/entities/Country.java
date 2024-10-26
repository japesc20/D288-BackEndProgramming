package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "countries")
//@Data
@Getter
@Setter

public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    // Each column from table 'countries' from the Mysql database & UML diagram
    @Column (name = "country_id")
    private Long id;

    @Column (name = "country")
    private String country_name;

    @Column (name = "create_date")
    @CreationTimestamp
    private Date create_date;

    @Column (name = "last_update")
    @UpdateTimestamp
    private Date last_update;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "country")
    private Set<Division> divisions;

    public Country() {

    };
}

