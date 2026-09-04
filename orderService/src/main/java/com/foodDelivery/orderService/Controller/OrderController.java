package com.foodDelivery.orderService.Controller;

import com.foodDelivery.orderService.Service.OrderService;
import com.foodDelivery.orderService.Entity.Order;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Integer id) {
        return orderService.getOrderById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable Integer id) {
        orderService.deleteOrder(id);
        return "Order deleted successfully";
    }
    @GetMapping("/check-restaurant/{restaurantId}")
public String checkRestaurant(@PathVariable Integer restaurantId) {
    return orderService.checkRestaurant(restaurantId);
}
@GetMapping("/check-user/{userId}")
public String checkUser(@PathVariable Integer userId) {
    return orderService.checkUser(userId);
}
}
