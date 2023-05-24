package com.rakib.springdatajpa.controller;

import com.rakib.springdatajpa.entity.Order;
import com.rakib.springdatajpa.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductOrderController {

    private final OrderService orderService;

    @PostMapping("/product-order")
    public Order submitOrders(@RequestBody Order order) {
        return orderService.submitOrders(order);

    }
}
