/*
 * com.springmvc.service.impl.SpringMVCServiceImpl.java 
 * 中免（深圳）商务科技有限公司.
 * Copyright 2016 by www.zhongmian.com All rights reserved.
 * 
 */
package com.springmvc.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.springmvc.service.SpringMVCService;

/**
 *	日期		:	2016年11月25日<br>
 *	作者		:	rupeng.yan<br>
 *	项目		:	springdemo<br>
 *	功能		:	<br>
 */
@Service
public class SpringMVCServiceImpl implements SpringMVCService {
	private Logger logger = LoggerFactory.getLogger(SpringMVCServiceImpl.class);
	/* (non-Javadoc)
	 * @see com.springmvc.service.SpringMVCService#getSomething()
	 */
	public String getSomething() {
		// TODO Auto-generated method stub
		testAspectJ();
		return "give you something";
	}

	private void testAspectJ() {
		logger.info("testAspectJ");
	}

}
