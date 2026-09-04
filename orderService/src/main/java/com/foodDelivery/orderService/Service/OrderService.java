package com.foodDelivery.orderService.Service;

import com.foodDelivery.orderService.Entity.Order;
import com.foodDelivery.orderService.Repository.OrderRepository;
import com.foodDelivery.orderService.client.UserClient;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final RestClient restClient;
    private final UserClient userClient;
    


    public OrderService(
        OrderRepository orderRepository,
        RestClient restClient,
        UserClient userClient) {

    this.orderRepository = orderRepository;
    this.restClient = restClient;
    this.userClient = userClient;
}
   public String checkUser(Integer userId) {

    return userClient.getUser(userId);
}

    // Order Service → Restaurant Service
    public String checkRestaurant(Integer restaurantId) {

        return restClient
                .get()
                .uri("http://RESTAURANTSERVICE/restaurants/" + restaurantId)
                .retrieve()
                .body(String.class);
    }

    // Create Order
    public Order createOrder(Order order) {

    // Check whether user exists
    checkUser(order.getUserId());

    // Check whether restaurant exists
    checkRestaurant(order.getRestaurantId());

    // Both exist → save order
    return orderRepository.save(order);
}

    // Get all Orders
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // Get Order by ID
    public Order getOrderById(Integer id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    // Delete Order
    public void deleteOrder(Integer id) {
        orderRepository.deleteById(id);
    }
}