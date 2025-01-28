package com.example.springtransaction.controller;

import com.example.springtransaction.service.OptimisticSeatBookingService;
import com.example.springtransaction.service.PessimisticSeatBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    private OptimisticSeatBookingService optimisticSeatBookingService;

    @Autowired
    private PessimisticSeatBookingService pessimisticSeatBookingService;
    @GetMapping("/optimistic/{seatId}")
    public String optimisticLocking(@PathVariable Long seatId) throws InterruptedException {
        optimisticSeatBookingService.testOptimisiticLocking(seatId);
        return "Optimistic Locking test started! Check logs for results";
    }
    @GetMapping("/pessimistic/{seatId}")
    public String pessimistic(@PathVariable Long seatId) throws InterruptedException {
        pessimisticSeatBookingService.bookSeatWithPessimisticMethod(seatId);
        return "Pessimistic Locking test started! Check logs for results";
    }


}
