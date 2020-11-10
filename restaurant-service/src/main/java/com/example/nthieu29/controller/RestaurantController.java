package com.example.nthieu29.controller;

import com.example.nthieu29.dto.GenerateRequest;
import com.example.nthieu29.service.RestaurantService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/restaurants")
public class RestaurantController {
    private final RestaurantService restaurantService;

    @PostMapping(path = "generate")
    public ResponseEntity generateRestaurant(@RequestBody GenerateRequest generateRequest) {
        restaurantService.generateSampleRestaurants(generateRequest.getNumberOfRestaurant());
        return ResponseEntity.accepted().build();
    }
}
