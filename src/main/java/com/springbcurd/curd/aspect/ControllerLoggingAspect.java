package com.springbcurd.curd.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ControllerLoggingAspect {

    private final Logger logger = LoggerFactory.getLogger(ControllerLoggingAspect.class);

    @Before("execution(* com.springbcurd.curd.service.CustomerService.*(..))")
    public void beforeMethodExecution(JoinPoint joinPoint) {
        logger.info("Entering method: {}", joinPoint.getSignature().getName());
    }

    @AfterReturning("execution(* com.springbcurd.curd.service.CustomerService.*(..))")
    public void afterMethodExecution(JoinPoint joinPoint) {
        logger.info("After method: {}", joinPoint.getSignature().getName());
    }
    
    @Around("execution(* com.springbcurd.curd.service.CustomerService.*(..))")
    public Object aroundMethodExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("Before method execution: {}", joinPoint.getSignature());
        Object result = joinPoint.proceed();
        logger.info("After method execution: {}", joinPoint.getSignature());
        return result;
    }
}

