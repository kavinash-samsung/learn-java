package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.demo.BeanConfig;
import com.example.demo.ShoppingCart;

public class Main {
    
    public static void main(String[] args) {
        System.out.println("Hello world!");
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        
        ShoppingCart shoppingCart = context.getBean(ShoppingCart.class);
        shoppingCart.checkout();
    }
}