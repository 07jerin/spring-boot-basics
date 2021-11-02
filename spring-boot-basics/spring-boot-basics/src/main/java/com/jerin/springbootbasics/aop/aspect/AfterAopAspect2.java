package com.jerin.springbootbasics.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
@Aspect
@Configuration
public class AfterAopAspect2 {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Before("execution(* com.jerin.springbootbasics.aop..*.*(..))")
	public void before(JoinPoint joinPoint) {
		logger.info("Intercepted method call {}", joinPoint);
	}

}
