package com.example.demo.entities;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "customers")
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "customer_id")
    private Long customer_id;

    @Column (name = "address")
    private String address;

    @Column (name = "create_date")
    private Date create_date;

    @Column (name = "customer_first_name")
    private String customer_first_name;

    @Column (name = "customer_last_name")
    private String customer_last_name;

    @Column (name = "last_update")
    private Date last_update;

    @Column (name = "phone")
    private String phone;

    @Column (name = "postal_code")
    private String postal_code;

    @Column (name = "division_id")
    private Long division_id;
}
