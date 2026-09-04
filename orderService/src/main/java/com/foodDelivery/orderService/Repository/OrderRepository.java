package com.foodDelivery.orderService.Repository;

import com.foodDelivery.orderService.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
