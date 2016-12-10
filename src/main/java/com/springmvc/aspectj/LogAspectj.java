/*
 * com.springmvc.aspectj.LogAspectj.java 
 * 中免（深圳）商务科技有限公司.
 * Copyright 2016 by www.zhongmian.com All rights reserved.
 * 
 */
package com.springmvc.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 *	日期		:	2016年12月1日<br>
 *	作者		:	rupeng.yan<br>
 *	项目		:	springdemo<br>
 *	功能		:	<br>
 */
@Component
@Aspect
public class LogAspectj {
	private Logger logger = LoggerFactory.getLogger(LogAspectj.class);

	@Pointcut("execution(* *getSomething(..))")
	public void test() {
	}

	@Before("test()")
	public void beforeTest(JoinPoint joinPoint) {

		logger.info("test before：{}", joinPoint.toShortString());
	}

	@After("test()")
	public void afterTest(JoinPoint joinPoint) {
		logger.info("test after");
	}

	@Around("test()")
	public Object aroundTest(ProceedingJoinPoint joinPoint) {
		logger.info("around before");
		Object o = null;
		try {
			o = joinPoint.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("around after");
		return o;
	}

	@AfterReturning(returning = "rvt", pointcut = "test()")
	public void afterreturn(Object rvt) {
		logger.info("afterreturning:{}", rvt);
	}
}
