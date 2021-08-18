package com.example.orderservice.application.controller;

import com.example.orderservice.application.domain.OrderEntity;
import com.example.orderservice.application.dto.ResponseOrder;
import com.example.orderservice.application.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/order-service")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping(value = "/{userId}/orders")
    public ResponseEntity<List<ResponseOrder>> getOrder(@PathVariable("userId") String userId) {
        Iterable<OrderEntity> orderList = orderService.getOrdersByUserId(userId);

        List<ResponseOrder> result = new ArrayList<>();
        orderList.forEach(orderEntity -> result.add(new ModelMapper().map(orderEntity, ResponseOrder.class)));

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

}
