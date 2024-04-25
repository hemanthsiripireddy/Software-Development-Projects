package com.hemanth.EcomV2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class RatingId implements Serializable {
    @Column(name = "product_id")
    private int productId;

    @Column(name = "user_id")
    private int userId;

    // Constructors, getters, and setters (including equals and hashCode)
}
