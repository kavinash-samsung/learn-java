package com.avinashh;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.avinashh.vehicle.Vehicle;

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
        Vehicle vehicle1 = context.getBean("myVehicle", Vehicle.class);
        Vehicle vehicle2 = context.getBean("myVehicle", Vehicle.class);
        // System.out.println(vehicle.getMileage());
        // System.out.println(vehicle.getMaximumRetailPrice());
        // System.out.println(vehicle.getDiscountMessage());
        // System.out.println(vehicle.getBrandName());
        System.out.println(vehicle1.equals(vehicle2));
        context.close();
    }
}
