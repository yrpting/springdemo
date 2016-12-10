/*
 * com.springmvc.aop.EnhancerDemo.java 
 * 中免（深圳）商务科技有限公司.
 * Copyright 2016 by www.zhongmian.com All rights reserved.
 * 
 */
package com.springmvc.aop;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 *	日期		:	2016年12月4日<br>
 *	作者		:	rupeng.yan<br>
 *	项目		:	springdemo<br>
 *	功能		:	<br>
 */
public class EnhancerDemo {
	private static Logger logger = LoggerFactory.getLogger(EnhancerDemo.class);
	public static void main(String[] args) {
		Enhancer e = new Enhancer();
		e.setSuperclass(EnhancerDemo.class);
		e.setCallback(new MethodInterceptorImpl());

		EnhancerDemo demo = (EnhancerDemo) e.create();
		demo.test();
		logger.info(demo.toString());
	}

	public void test() {
		logger.info("enhancerdemo test");
	}
	private static class MethodInterceptorImpl implements MethodInterceptor {

		/*
		 * (non-Javadoc)
		 * 
		 * @see net.sf.cglib.proxy.MethodInterceptor#intercept(java.lang.Object, java.lang.reflect.Method, java.lang.Object[], net.sf.cglib.proxy.MethodProxy)
		 */
		@Override
		public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
			logger.info("before method:{}", method);
			Object object = proxy.invokeSuper(obj, args);
			logger.info("after method:{}", method);
			return object;
		}

	}
}
