package com.example.springtransaction.service;

import com.example.springtransaction.entity.Seat;
import com.example.springtransaction.repository.SeatRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class MovieTicketBookingService {
    @Autowired
    private SeatRepository seatRepository;

    @Transactional
    public Seat bookSeat(Long seatId){
        // fetch the existing seat by Id
        Seat seat = seatRepository.findById(seatId).orElseThrow(()-> new RuntimeException("Seat not found with id"+seatId));
        log.info(Thread.currentThread().getName()+" fetched seat with version "+seat.getVersion());
        if(seat.isBooked()){
            throw new RuntimeException("Seat is already booked");
        }
        seat.setBooked(true);
        //version check with occur
        seatRepository.save(seat);
        return seat;
    }

    @Transactional
    public void bookSeatWithPessimisticLock(Long seatId) throws InterruptedException {
        // fetch the existing seat by Id
        System.out.println(Thread.currentThread().getName()+" is attempting to fetch the seat ");
        Seat seat = seatRepository.findByIdAndLock(seatId);
        log.info(Thread.currentThread().getName()+" acquired the lock for "+seat.getId());
        if(seat.isBooked()){
            System.out.println((Thread.currentThread().getName()+" Seat is already booked "+seat.getMovieName()));
            throw new RuntimeException("Seat is already booked");
        }
        System.out.println(Thread.currentThread().getName()+" is booking the seat "+ seat.getMovieName());
        seat.setBooked(true);
        Thread.sleep(5000);
        seatRepository.save(seat);
        System.out.println(Thread.currentThread().getName()+" isuccessfully booked seat "+ seat.getMovieName());
        //version check with occur

    }
}
