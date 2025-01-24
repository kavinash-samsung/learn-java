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
        System.out.println("Withing authentication point cut");
    }

    @Pointcut("within(com.example.demo..*)")
    public void authorizationPointCut(){
        System.out.println("Withing authorization point cut");
    }

    @Before("authenticatingPointCut() || authorizationPointCut()")
    public void authenticate(){
        System.out.println("Authenticating...");
    }
}
