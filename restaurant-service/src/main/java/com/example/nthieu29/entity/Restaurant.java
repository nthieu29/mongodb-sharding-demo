package com.example.nthieu29.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {
    @Id
    private String id;
    private String name;
    private String cuisine;
    private double stars;
    @Indexed
    private String city;

    public Restaurant(String name, String cuisine, double stars, String city) {
        this.name = name;
        this.cuisine = cuisine;
        this.stars = stars;
        this.city = city;
    }
}
