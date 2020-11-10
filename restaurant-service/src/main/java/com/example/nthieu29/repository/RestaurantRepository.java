package com.example.nthieu29.repository;

import com.example.nthieu29.entity.Restaurant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "restaurants", path = "restaurants")
public interface RestaurantRepository extends MongoRepository<Restaurant, String> {
}
