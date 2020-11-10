package com.example.nthieu29.controller;

import com.example.nthieu29.dto.GenerateRequest;
import com.example.nthieu29.service.RestaurantService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/restaurants")
@Slf4j
public class RestaurantController {
    private final RestaurantService restaurantService;

    @PostMapping(path = "generate")
    public ResponseEntity generateRestaurant(@RequestBody GenerateRequest generateRequest) {
        int numberOfRestaurant = generateRequest.getNumberOfRestaurant();
        log.info("Started to generated {} restaurants", numberOfRestaurant);
        restaurantService.generateSampleRestaurants(numberOfRestaurant);
        return ResponseEntity.accepted().build();
    }
}
