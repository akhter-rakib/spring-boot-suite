package com.rakib.springdatajpa.service;

import com.rakib.springdatajpa.entity.Order;
import com.rakib.springdatajpa.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Override
    public Order submitOrders(Order order) {
        return orderRepository.save(order);
    }
}
