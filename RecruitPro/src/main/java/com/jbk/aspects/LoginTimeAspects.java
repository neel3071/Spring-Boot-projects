package com.jbk.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoginTimeAspects {
	 Logger logger = LoggerFactory.getLogger(LoginTimeAspects.class);	
	
		
//	@Before("execution(*com.jbk.controller.*.*())")
//	public void startertime() {
//		System.out.println("Start time = " + LocalDateTime.now());
		
//	}
	
	
	@Around("execution(* com.jbk.controller.*.*(..))")
	public Object Tracexecutiontime(ProceedingJoinPoint joinpoint) throws Throwable {
		long StartTime = System.currentTimeMillis();
		Object object = joinpoint.proceed();
		long EndTime = System.currentTimeMillis();
		System.out.println("time ="+ (EndTime - StartTime));
		
		 logger.info("Excution time " +(EndTime - StartTime));
		return object;
		
	}

}
