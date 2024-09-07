package com.avinashh;

import org.springframework.context.support.ClassPathXmlApplicationContext;

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
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        Vehicle vehicle1 = context.getBean("car", Vehicle.class);
        Vehicle vehicle2 = context.getBean("car", Vehicle.class);
        // System.out.println(vehicle.getMileage());
        // System.out.println(vehicle.getDiscountMessage());
        // System.out.println(vehicle.getMrp());
        System.out.println(vehicle1.equals(vehicle2));
    }
}
