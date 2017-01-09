/*
 * com.springdemo.test.Demo.java 
 * 中免（深圳）商务科技有限公司.
 * Copyright 2017 by www.zhongmian.com All rights reserved.
 * 
 */
package com.springdemo.test;

/**
 *	日期		:	2017年1月6日<br>
 *	作者		:	rupeng.yan<br>
 *	项目		:	springdemo<br>
 *	功能		:	<br>
 */
public class Demo {
	public static void main(String[] args) {
		String str = new String("good");
		char[] ch = { 'a', 'b', 'c' };
		change(str, ch);
		System.out.print(str + "and");
		System.out.print(ch);
	}

	public static void change(String str, char[] ch) {
		str = "test ok";
		ch[0] = 'g';
	}
}
