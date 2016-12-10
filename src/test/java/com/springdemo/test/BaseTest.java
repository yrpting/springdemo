/*
 * com.springdemo.test.BaseTest.java 
 * 中免（深圳）商务科技有限公司.
 * Copyright 2016 by www.zhongmian.com All rights reserved.
 * 
 */
package com.springdemo.test;

import org.junit.Before;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 日期 : 2016年12月2日<br>
 * 作者 : rupeng.yan<br>
 * 项目 : springdemo<br>
 * 功能 : <br>
 */
public abstract class BaseTest {
	protected ClassPathXmlApplicationContext ac;

	@Before
	public void before() {
		if (ac == null) {
			ac = new ClassPathXmlApplicationContext(new String[] { "classpath:spring/application*.xml", "classpath:spring-mvc.xml" });
		}
		init();
	}

	abstract void init();

}
