package com.example.demo.entities;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "customers")
//@Data
@Getter
@Setter

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    // Each column from table 'customers' from the Mysql database & UML diagram
    @Column (name = "customer_id")
    private Long id;

    @Column (name = "customer_first_name")
    private String firstName;

    @Column (name = "customer_last_name")
    private String lastName;

    @Column (name = "address")
    private String address;

    @Column (name = "postal_code")
    private String postal_code;

    @Column (name = "phone")
    private String phone;

    @Column (name = "create_date")
    @CreationTimestamp
    private Date create_date;

    @Column (name = "last_update")
    @UpdateTimestamp
    private Date last_update;

    @ManyToOne
    @JoinColumn(name = "division_id")
    private Division division;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private Set<Cart> carts = new HashSet<>();

    public void add(Cart cart) {
        this.carts.add(cart);
    }

    public Customer() {

    };
}
