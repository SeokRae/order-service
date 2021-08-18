package com.example.orderservice.application.service;

import com.example.orderservice.application.domain.OrderEntity;
import com.example.orderservice.application.dto.OrderDto;

public interface OrderService {
    OrderDto createOrder(OrderDto orderDetails);
    OrderDto getOrderByOrderId(String orderId);
    Iterable<OrderEntity> getOrdersByUserId(String userId);
}
