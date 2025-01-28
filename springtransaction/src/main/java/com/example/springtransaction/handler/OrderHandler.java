package com.example.springtransaction.handler;

import com.example.springtransaction.entity.Order;
import com.example.springtransaction.error.DatabaseCrashException;
import com.example.springtransaction.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderHandler {

    private final OrderRepository orderRepository;

    public OrderHandler(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order saveOrder(Order order) throws DatabaseCrashException {
        throw new DatabaseCrashException("DB CRASHED....");
//        return orderRepository.save(order);
    }
}