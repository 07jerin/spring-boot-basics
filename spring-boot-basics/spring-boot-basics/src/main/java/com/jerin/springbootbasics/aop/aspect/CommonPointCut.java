package com.jerin.springbootbasics.aop.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointCut {
	
	@Pointcut("@annotation(com.jerin.springbootbasics.aop.aspect.TrackTime)")
	public void trackTimeAnnotation() {
		
	}

}
