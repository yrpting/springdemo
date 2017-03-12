/*
 * com.springmvc.service.impl.SpringMVCServiceImpl.java 
 * 中免（深圳）商务科技有限公司.
 * Copyright 2016 by www.zhongmian.com All rights reserved.
 * 
 */
package com.springmvc.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.dao.UserMapper;
import com.springmvc.model.User;
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
	
	@Autowired
	private UserMapper userMapper;
	/* (non-Javadoc)
	 * @see com.springmvc.service.SpringMVCService#getSomething()
	 */
	public String getSomething(String str) {
		logger.info("getSomething():{}", str);
		testAspectJ();
		return "give you something";
	}

	private void testAspectJ() {
		logger.info("testAspectJ");
	}

    @Override
    public List<User> listUsers() {
        return userMapper.listUsers();
    }

}
