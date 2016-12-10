/*
 * com.springmvc.interceptors.UseTimeInterceptor.java 
 * 中免（深圳）商务科技有限公司.
 * Copyright 2016 by www.zhongmian.com All rights reserved.
 * 
 */
package com.springmvc.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *	日期		:	2016年11月28日<br>
 *	作者		:	rupeng.yan<br>
 *	项目		:	springdemo<br>
 *	功能		:	<br>
 */
public class UseTimeInterceptor extends HandlerInterceptorAdapter {
	private Logger logger = LoggerFactory.getLogger(UseTimeInterceptor.class);
	private ThreadLocal<Long> startTime = new ThreadLocal<Long>();
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.web.servlet.handler.HandlerInterceptorAdapter#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		this.startTime.set(System.currentTimeMillis());
		//System.out.println("handler:--------------" + ((HandlerMethod) handler).getMethod().getName());
		logger.info("{} preHandle execute at {}", this.getClass().getSimpleName(), this.startTime.get());
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.web.servlet.handler.HandlerInterceptorAdapter#postHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.web.servlet.ModelAndView)
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		//System.out.println("handler:--------------" + ((HandlerMethod) handler).getMethod().getName());
		logger.info("{} postHandle execute", this.getClass().getSimpleName());
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.web.servlet.handler.HandlerInterceptorAdapter#afterCompletion(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		long endtime = System.currentTimeMillis();
		//System.out.println("handler:--------------" + ((HandlerMethod) handler).getMethod().getName());
		logger.info("{} time used:{}", this.getClass().getSimpleName(), endtime - startTime.get());
		logger.info("{} afterCompletion execute at {};startTime:{}", this.getClass().getSimpleName(), endtime, this.startTime.get());
	}
}
