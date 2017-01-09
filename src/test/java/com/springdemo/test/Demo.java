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
public class Demo extends Parent{
	public static void main(String[] args) {
//		String str = new String("good");
//		char[] ch = { 'a', 'b', 'c' };
//		change(str, ch);
//		System.out.print(str + "and");
//		System.out.print(ch);
Demo d=new Demo();
d.printxxx();
	}
	public Demo(){
	    super();
	    System.out.println("demo");
	}
    public void printxxx(){
        System.out.println("demo printxxx");
        super.printxxx();
    }
    
	public static void change(String str, char[] ch) {
		str = "test ok";
		ch[0] = 'g';
	}
}
class Parent{
    public Parent(){
        System.out.println("parent");
    }
    public void printxxx(){
        System.out.println("parent printxxx");
    }
}