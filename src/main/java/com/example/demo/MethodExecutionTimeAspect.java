package com.example.demo;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MethodExecutionTimeAspect {

    @Around("@annotation(LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        final long start = System.currentTimeMillis();
        
        final Object proceed = joinPoint.proceed();
        

        final long executionTime = System.currentTimeMillis() - start;

        System.out.println("Target : " + joinPoint.getTarget().getClass().getCanonicalName()  + ".\nKind :"  + joinPoint.getKind() + "\n"+ joinPoint.getSignature() + " executed in " + executionTime + "ms" );
        
		/*
		 * Method mth = null; try { mth = (Method)
		 * joinPoint.getStaticPart().getSignature(); } catch (SecurityException e1) { //
		 * TODO Auto-generated catch block e1.printStackTrace(); } LogExecutionTime
		 * annotation = mth.getAnnotation(LogExecutionTime.class);
		 * System.out.println("annotation enabled ::: " + annotation.enabled());
		 */
        
        return proceed;
    }

}
