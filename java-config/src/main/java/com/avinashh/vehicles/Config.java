package com.avinashh.vehicles;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.avinashh.vehicles")
@PropertySource("car.properties")
public class Config {
    @Bean
    public Vehicle carr(){
        Car car = new Car(festivalDiscountService());
        return car;
    }

    @Bean
    public DiscountService festivalDiscountService(){
        return new FestivalDiscountServiceImpl();
    }

}
