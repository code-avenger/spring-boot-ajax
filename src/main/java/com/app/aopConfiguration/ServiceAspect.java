package com.app.aopConfiguration;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAspect {

    @Before(value = "execution(* com.app.services.*.*(..))")
    public void beforeService(JoinPoint joinPoint) {
	System.out.println(joinPoint.toString());
	System.out.println(
		"********************* this is for all the service methods. Implement the code as per requirement");

    }

    @Before(value = "execution(* com.app.controller.*.*(..))")
    public void beforeController(JoinPoint joinPoint) {
	System.out.println(joinPoint.toString());
	System.out.println(
		"#################### this is for all the controller methods. ");

    }

}
