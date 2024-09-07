package com.avinashh.vehicles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Car implements Vehicle{
    
    // @Autowired
    // @Qualifier("festivalDiscountServiceImpl")
    private DiscountService discountService;

    @Value("${car.mrp}")
    private Double mrp;

    // @Autowired
    // public void setDiscountService(DiscountService discountService) {
    //     this.discountService = discountService;
    // }

    public Double getMrp() {
        return mrp;
    }

    @Autowired
    public Car(@Qualifier("festivalDiscountServiceImpl") DiscountService discountService){
        this.discountService = discountService;
    }

    @Override
    public String getDiscountMessage(){
        return this.discountService.getDiscountMessage();
    }
    @Override
    public String getMileage(){
        return "30KMPL";
    }
}
