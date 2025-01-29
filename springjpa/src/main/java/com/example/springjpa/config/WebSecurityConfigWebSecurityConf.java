package com.example.springjpa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;



@Configuration

public class WebSecurityConfigWebSecurityConf{

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> webSecurityCustomizer();
    }
    
}
