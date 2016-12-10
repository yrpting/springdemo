/*
 * com.springmvc.service.impl.UserServiceImpl.java 
 * 中免（深圳）商务科技有限公司.
 * Copyright 2016 by www.zhongmian.com All rights reserved.
 * 
 */
package com.springmvc.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.springmvc.service.UserService;

/**
 *	日期		:	2016年12月4日<br>
 *	作者		:	rupeng.yan<br>
 *	项目		:	springdemo<br>
 *	功能		:	<br>
 */
public class UserServiceImpl implements UserService {
	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	/* (non-Javadoc)
	 * @see com.springmvc.service.UserService#add()
	 */
	@Override
	public String add() {
		logger.info("user add -----");
		return "add success";
	}

}
