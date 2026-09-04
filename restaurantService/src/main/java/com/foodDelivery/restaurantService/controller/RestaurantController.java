package com.foodDelivery.restaurantService.controller;



import com.foodDelivery.restaurantService.service.RestaurantService;
import com.foodDelivery.restaurantService.entity.Restaurant;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping
    public Restaurant createRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantService.createRestaurant(restaurant);
    }

    @GetMapping
    public List<Restaurant> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }
    @GetMapping("/{id}")
public Restaurant getRestaurantById(@PathVariable Integer id) {
    return restaurantService.getRestaurantById(id);
}
}
