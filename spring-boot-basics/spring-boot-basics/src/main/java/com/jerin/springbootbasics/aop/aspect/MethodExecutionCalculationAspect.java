package com.jerin.springbootbasics.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class MethodExecutionCalculationAspect {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Around(value = "execution(* com.jerin.springbootbasics.aop.business.*.*(..))")
	public void around(ProceedingJoinPoint proceedigJoinPoint) throws Throwable {
		long startTime = System.currentTimeMillis();
		proceedigJoinPoint.proceed();
		long timeTaken = System.currentTimeMillis() - startTime;
		logger.info(" Time taken by {} is {}", proceedigJoinPoint, timeTaken);
	}
	
	
	@Around("com.jerin.springbootbasics.aop.aspect.CommonPointCut.trackTimeAnnotation()")
	public void customTimeTrace(ProceedingJoinPoint proceedigJoinPoint) throws Throwable {
		long startTime = System.currentTimeMillis();
		proceedigJoinPoint.proceed();
		long timeTaken = System.currentTimeMillis() - startTime;
		logger.info(" CUSTOM annotation track for {}, time taken {}", proceedigJoinPoint, timeTaken);
	}
}
