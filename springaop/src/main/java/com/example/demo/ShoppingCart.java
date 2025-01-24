package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class ShoppingCart {
    
    public void checkout(){
        System.out.println("Checkout method from shopping cart called");
    }
}
