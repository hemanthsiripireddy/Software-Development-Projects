package com.hemanth.EcomV2.entity;

import jakarta.persistence.*;

import java.util.List;
@Entity
public class WishList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int wishlist_id;
    @OneToOne(mappedBy = "wishList", cascade = CascadeType.ALL)
    private User user;
    @ManyToMany
    @JoinTable(
            name = "wishlist_product",
            joinColumns = @JoinColumn(name = "wishlist_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    List<Product> lists;
}
