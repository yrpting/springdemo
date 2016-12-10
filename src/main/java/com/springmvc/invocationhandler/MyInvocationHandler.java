/*
 * com.springmvc.invocationhandler.MyInvocationHandler.java 
 * 中免（深圳）商务科技有限公司.
 * Copyright 2016 by www.zhongmian.com All rights reserved.
 * 
 */
package com.springmvc.invocationhandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *	日期		:	2016年12月4日<br>
 *	作者		:	rupeng.yan<br>
 *	项目		:	springdemo<br>
 *	功能		:	<br>
 */
public class MyInvocationHandler<T> implements InvocationHandler {
	private Logger logger = LoggerFactory.getLogger(MyInvocationHandler.class);
	private T target;

	public MyInvocationHandler(T target) {
		this.target=target;
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		logger.info("before method execute");
		Object ret = method.invoke(target, args);
		logger.info("after method execute");
		return ret;
	}

	@SuppressWarnings("unchecked")
	public T getProxy() {
		return (T) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), target.getClass().getInterfaces(), this);
	}
}
