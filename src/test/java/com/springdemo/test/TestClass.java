/*
 * springdemo.TestClass.java 
 * 中免（深圳）商务科技有限公司.
 * Copyright 2016 by www.zhongmian.com All rights reserved.
 * 
 */
package com.springdemo.test;

import org.junit.Test;

import com.springmvc.invocationhandler.MyInvocationHandler;
import com.springmvc.service.UserService;
import com.springmvc.service.impl.UserServiceImpl;

/**
 *	日期		:	2016年12月2日<br>
 *	作者		:	rupeng.yan<br>
 *	项目		:	springdemo<br>
 *	功能		:	<br>
 */
public class TestClass extends BaseTest {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.springdemo.test.BaseTest#init()
	 */
	@Override
	void init() {

	}

	@Test
	public void test() {
	}

	@Test
	public void testProxy() {
		UserService service = new UserServiceImpl();
		MyInvocationHandler<UserService> handler = new MyInvocationHandler<>(service);

		UserService proxy = handler.getProxy();
		proxy.add();
	}

	public static void main(String[] args) {
	     String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program" + "ming";
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1 == s1.intern());
        /*short s =1;
        s +=1;
        System.out.println(s);
	    Integer a=new Integer(127);
	    Integer b=new Integer(127);
	    System.out.println(a==b);
	    
		Node first = new Node(100);
		Node tmp = first;

		for (int i = 0; i < 5; ++i) {
			Node b = new Node(i);
			tmp.setNext(b);
			tmp = b;
		}
		tmp = first;
		while (tmp != null) {
			System.out.print(tmp.getId() + ":");
			tmp = tmp.getNext();
		}
		System.out.println();
		reverse(first);
		*/
	}

	public static void reverse(Node first) {
		Node currNext = first.getNext();
		Node curr = first;
		first.setNext(null);
		Node tmp;
		while (true) {
			tmp = currNext.getNext();
			currNext.setNext(curr);
			curr = currNext;
			if (tmp == null)
				break;
			currNext = tmp;
		}

		tmp = curr;
		while (tmp != null) {
			System.out.print(tmp.getId() + ":");
			tmp = tmp.getNext();
		}
	}
}

class Node {
	private int id;
	private Node next;

	public Node(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public boolean hasNext() {
		return this.next != null;
	}
}