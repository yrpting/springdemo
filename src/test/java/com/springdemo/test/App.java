/*
 * com.springdemo.test.App.java 
 * 中免（深圳）商务科技有限公司.
 * Copyright 2017 by www.zhongmian.com All rights reserved.
 * 
 */
package com.springdemo.test;

/**
 * 日期 : 2017年1月6日<br>
 * 作者 : rupeng.yan<br>
 * 项目 : springdemo<br>
 * 功能 : <br>
 */
public class App {
	public static void main(String[] args) {
		System.out.println("------main start------");
		A a1 = new A();
		String aaa = "ddfaw";
		char[] strs = aaa.toCharArray();

		System.out.println("------main end------");
	}

	static public class A extends BaseA {
		int m1 = 1;

		public A() {
			m1 = 0;
			System.out.println("INIT A");
		}

		{
			System.out.println(m1 == super.m1);
		}
	}

	static public class BaseA {
		int m1 = 2;
		static int m2 = 5;

		public BaseA() {
			System.out.println("INIT BaseA");
			m1 = 1;
		}

		{
			System.out.println(++m1);
		}
		static {
			System.out.println(m2);
		}
	}

	static {
		System.out.println("------main ing------");
	}

	public void init() {
		System.out.println("------main init------");
	}

	public App() {
		System.out.println("------main main------");
	}
}