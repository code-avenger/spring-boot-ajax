package com.app.aopConfiguration;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.app.model.User;

@Aspect
@Component
public class ServiceAspect {

    @Before(value = "execution(* com.app.services.*.*(..))")
    public void beforeService(JoinPoint joinPoint) {
	System.out.println(
		"********************* this is before all the service methods. Implement the code as per requirement");
	System.out.println(joinPoint.toString());

    }

    @AfterReturning(pointcut = "execution(* com.app.services.*.*(..))", returning = "list")
    public void afterReturningValue(JoinPoint joinPoint, List<User> list) {
	System.out.println("********************* this is after all the service methods.");
	System.out.println(joinPoint.toString());
	System.out.println(list);


    }

    @Before(value = "execution(* com.app.controller.*.*(..))")
    public void beforeController(JoinPoint joinPoint) {
	System.out.println(
		"#################### this is for all the controller methods. ");
	System.out.println(joinPoint.toString());

    }

}
