package com.example.demo.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "divisions")
@Getter
@Setter

public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    // Each column from table 'divisions' from the Mysql database & UML diagram
    @Column (name = "division_id")
    private Long id;

    @Column (name = "division")
    private String division_name;

    @Column (name = "create_date")
    @CreationTimestamp
    private Date create_date;

    @Column (name = "last_update")
    @UpdateTimestamp
    private Date last_update;

    @ManyToOne
    @JoinColumn (name = "country_id", insertable = false, updatable = false)
    private Country country;

    @Column (name = "country_id")
    private Long country_id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "division")
    private Set<Customer> customers;

}
