package com.example.demo;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuthenticationAspect {

    @Pointcut("within(com.example.demo..*)")
    public void authenticationPointCut(){

    }

    @Pointcut("within(com.example.demo..*)")
    public void authorizationPointCut(){

    }

    @Before("authenticatingPointCut() && authorizationPointCut()")
    public void authenticate(){
        System.out.println("Authenticating...");
    }
}
