package com.avinashh.vehicles;

import org.springframework.stereotype.Component;

@Component
public class NoDiscountServiceImpl implements DiscountService{
    @Override
    public String getDiscountMessage(){
        return "No Discount";
    }
}
