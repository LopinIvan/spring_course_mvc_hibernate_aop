package com.lopinivan.spring.mvc_hibernate_aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @Around("execution(* com.lopinivan.spring.mvc_hibernate_aop.dao.*.*(..))")
    public Object aroundAllRepositoryMethodsAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        String methodName = methodSignature.getMethod().getName();

        System.out.println("Начинает работу метод: " + methodName);

        Object targetMethodResult = proceedingJoinPoint.proceed();

        System.out.println("Закончил работу метод: " + methodName);

        return targetMethodResult;
    }

}
