package com.avinashh.vehicles;

import org.springframework.stereotype.Component;

@Component
public class WWEDiscountServiceImpl implements DiscountService{
    @Override
    public String getDiscountMessage(){
        return "Here is your 1% discount while match is going on";
    }
}
