package com.hemanth.EcomV2.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class Rating {

//    private int productId;
//    private int userId;

    @EmbeddedId
    private RatingId id;

    private int rating;
}
