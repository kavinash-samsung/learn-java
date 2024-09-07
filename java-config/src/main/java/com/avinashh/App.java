package com.avinashh;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.avinashh.vehicles.Config;
import com.avinashh.vehicles.Vehicle;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Vehicle vehicle = context.getBean("carr", Vehicle.class);
        System.out.println(vehicle.getMileage());
        System.out.println(vehicle.getDiscountMessage());
        System.out.println(vehicle.getMrp());
    }
}
