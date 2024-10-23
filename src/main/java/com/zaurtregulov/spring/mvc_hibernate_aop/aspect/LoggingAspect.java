package com.zaurtregulov.spring.mvc_hibernate_aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

//Как решить проблему N+1???
//Используйте JOIN FETCH для оптимизации запроса:
//В запросе можно использовать JOIN FETCH,
//чтобы Hibernate загрузил связанные сущности в один запрос,
//что предотвратит проблему N+1.
//ОБНОВИТЬ ЗАПРОС В DAO
//                    ЗАПРОС                       //
//SELECT e FROM Employee e JOIN FETCH e.empDetails //

@Component
@Aspect
public class LoggingAspect {

    @Around("execution(* com.zaurtregulov.spring.mvc_hibernate_aop.dao.*.*(..))")
    public Object aroundAllRepositoryMethodsAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        String methodName = methodSignature.getMethod().getName();

        System.out.println("Начинает работу метод: " + methodName);

        Object targetMethodResult = proceedingJoinPoint.proceed();

        System.out.println("Закончил работу метод: " + methodName);

        return targetMethodResult;
    }

}
