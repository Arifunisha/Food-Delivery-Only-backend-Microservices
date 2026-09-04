package com.foodDelivery.restaurantService.service;



import com.foodDelivery.restaurantService.Repository.RestaurantRepository;
import com.foodDelivery.restaurantService.entity.Restaurant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public Restaurant createRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }
    public Restaurant getRestaurantById(Integer id) {
    return restaurantRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Restaurant not found"));
}
}
