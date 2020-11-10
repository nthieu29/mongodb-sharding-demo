package com.example.nthieu29.service;

import com.example.nthieu29.entity.Restaurant;
import com.example.nthieu29.repository.RestaurantRepository;
import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    @Async
    public void generateSampleRestaurants(int numberOfRestaurant) {
        Faker faker = new Faker();
        List<Restaurant> restaurants = new ArrayList<>();
        for (int i = 0; i < numberOfRestaurant; i++) {
            String name = faker.name().name() + " " + faker.food().dish();
            String cuisine = faker.country().name();
            double stars = faker.number().randomDouble(1, 0, 5);
            String city = faker.address().city();
            Restaurant restaurant = new Restaurant(name, cuisine, stars, city);
            restaurants.add(restaurant);
        }
        restaurantRepository.saveAll(restaurants);
    }

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public Restaurant addRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }
}
