package com.avinashh.vehicles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


public class Car implements Vehicle{
    

    private DiscountService discountService;

    @Value("${car.mrp}")
    private Double mrp;

    public Car(DiscountService discountService){
        this.discountService=discountService;
    }

    @Override
    public String getMileage(){
        return "30KMPL";
    }

    @Override
    public String getDiscountMessage(){
        return this.discountService.getDiscountMessage();
    }

    public DiscountService getDiscountService() {
        return discountService;
    }

    public Double getMrp() {
        return mrp;
    }
}
