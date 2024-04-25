package com.hemanth.EcomV2.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class Review {

    @EmbeddedId
    private RatingId id;

    private  String review;

}
