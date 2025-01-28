package com.example.springtransaction.controller;

import com.example.springtransaction.entity.Order;
import com.example.springtransaction.error.DatabaseCrashException;
import com.example.springtransaction.service.OrderProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderProcessingController {

    @Autowired
    private OrderProcessingService orderProcessingService;

    @PostMapping("/processorder")
    public ResponseEntity<?> placeOrder(@RequestBody Order order) throws DatabaseCrashException {
        return ResponseEntity.ok(orderProcessingService.placeAnOrder(order));
    }
}
