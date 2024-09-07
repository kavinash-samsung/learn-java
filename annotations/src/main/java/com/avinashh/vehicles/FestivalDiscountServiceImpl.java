package com.avinashh.vehicles;

import org.springframework.stereotype.Component;

@Component
public class FestivalDiscountServiceImpl implements DiscountService{
    
    @Override
    public String getDiscountMessage(){
        return "Please contact to out customer care service";
    }
}
