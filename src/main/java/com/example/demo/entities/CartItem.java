package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;


@Entity
@Table (name = "cart_items")
@Data

public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    // Each column from table 'cart_items' from the Mysql database & UML diagram
    @Column (name = "cart_item_id")
    private Long id;

    @ManyToOne
    @JoinColumn (name = "vacation")
    private Vacation vacation;

    @ManyToMany
    @JoinTable(
            name = "excursion_cartitem",
            joinColumns = @JoinColumn(name = "cart_item_id"),
            inverseJoinColumns = @JoinColumn(name = "excursion_id")
    )
    private Set<Excursion> excursions;

    @ManyToOne
    @JoinColumn (name = "cart_id")
    private Cart cart;

    @Column (name = "create_date")
    private Date create_date;

    @Column (name = "last_update")
    private Date last_update;

    public CartItem() {

    };
}
