package com.example.springtransaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessimisticSeatBookingService {
    @Autowired
    private MovieTicketBookingService movieTicketBookingService;

    public void bookSeatWithPessimisticMethod(Long seatId) throws InterruptedException {
        Thread t1 = new Thread(()->{
            try{
                System.out.println(Thread.currentThread().getName()+" is starting to call book seat method with id "+ seatId);
                movieTicketBookingService.bookSeatWithPessimisticLock(seatId);
                System.out.println(Thread.currentThread().getName()+" is finished to call book seat method with id "+ seatId);
            }catch (Exception e) {
                System.out.println(Thread.currentThread().getName() + " is failed to book seat thrown with exception " + seatId);
            }
        });
        Thread t2 = new Thread(()->{
            try{
                System.out.println(Thread.currentThread().getName()+" is starting to call book seat method with id "+ seatId);
                movieTicketBookingService.bookSeatWithPessimisticLock(seatId);
                System.out.println(Thread.currentThread().getName()+" is finished to call book seat method with id "+ seatId);
            }catch (Exception e) {
                System.out.println(Thread.currentThread().getName() + " is failed to book seat thrown with exception " + seatId);
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

    }
}
