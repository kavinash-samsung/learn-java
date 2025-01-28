package com.example.springtransaction.service;

import com.example.springtransaction.entity.Seat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OptimisticSeatBookingService {
    @Autowired
    private MovieTicketBookingService movieTicketBookingService;

    public void testOptimisiticLocking(Long seatId) throws InterruptedException {

        Thread t1 = new Thread(()->{
            try{
                System.out.println(Thread.currentThread().getName()+" is attempting to book thread");
                Seat seat = movieTicketBookingService.bookSeat(seatId);
                System.out.printf(Thread.currentThread().getName()+" is successfully booked thread");
            }catch (Exception e){
                System.out.println(Thread.currentThread().getName()+" is failed to book the ticket");
            }

        });

        Thread t2 = new Thread(()->{
            try{
                System.out.println(Thread.currentThread().getName()+" is attempting to book thread");
                Seat seat = movieTicketBookingService.bookSeat(seatId);
                System.out.printf(Thread.currentThread().getName()+" is successfully booked thread");
            }catch (Exception e){
                System.out.println(Thread.currentThread().getName()+" is failed to book the ticket");
            }
        });

        t1.start();
//        Thread.sleep(100);
        t2.start();
        t1.join();
        t2.join();
        t1.interrupt();
        t2.interrupt();
    }
}
