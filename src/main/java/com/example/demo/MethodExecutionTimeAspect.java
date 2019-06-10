package com.example.demo;

import java.lang.annotation.Annotation;

 
import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Aspect
@Component
public class MethodExecutionTimeAspect {

	@Autowired
	AuditProperties auditProperties;
	
	@Around("@annotation(LogExecutionTime)")
	public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
		/*
		 * MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		 * Method method = signature.getMethod();
		 * 
		 * LogExecutionTime logExecutionAnnonation =
		 * method.getAnnotation(LogExecutionTime.class);
		 */

		final long start = System.currentTimeMillis();

		// this indicates the actual method invocation
		final Object proceed = joinPoint.proceed();
		if (auditProperties.isEnabled()) {
			final long executionTime = System.currentTimeMillis() - start;
			System.out.println("Target : " + joinPoint.getTarget().getClass().getCanonicalName() + "\nKind :"
					+ joinPoint.getKind() + "\n" + joinPoint.getSignature() + " executed in " + executionTime + "ms");


		}
		return proceed;

	}

}
