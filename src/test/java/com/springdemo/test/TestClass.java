/*
 * springdemo.TestClass.java 
 * 中免（深圳）商务科技有限公司.
 * Copyright 2016 by www.zhongmian.com All rights reserved.
 * 
 */
package com.springdemo.test;

import java.util.Arrays;

import org.junit.Test;

import com.springmvc.invocationhandler.MyInvocationHandler;
import com.springmvc.service.UserService;
import com.springmvc.service.impl.UserServiceImpl;

/**
 * 日期 : 2016年12月2日<br>
 * 作者 : rupeng.yan<br>
 * 项目 : springdemo<br>
 * 功能 : <br>
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

	@Test
	public void testStr() {
		char[] chars = new char[] { '\u0097' };
		String str = new String(chars);
		byte[] bytes = str.getBytes();
		System.out.println('\u0097');
		System.out.println(chars);
		System.out.println(str);
		System.out.println(Double.NaN);
		System.out.println(Arrays.toString(bytes));
	}
static void add(Byte a){
    a=a++;
}
	public static void main(String[] args) throws InterruptedException {
	    Byte a = 127;
	    Byte b = 127;
	    add(++a);
	    System.out.println(a);
	    add(b);
	    System.out.println(b);
	    int i = 4;
	    System.out.println(Integer.toBinaryString(i));
		System.out.println(Integer.toBinaryString(-i));
		System.out.println(Integer.toBinaryString(-i>>2));
		System.out.println(-i>>2);
		System.out.println(-i>>>2);
		System.out.println(Integer.toBinaryString(-i>>>2));
	    LRUCache<String, String> lru = new LRUCache<>(5);
		lru.put("aaa", null);
		lru.put("ddd", null);
		lru.put("ccc", null);
		lru.put("bbb", null);
		lru.get("aaa");
		lru.put("eee", null);
		lru.put("fff", null);
		//System.out.println(lru);
	    //Child c = new Child("哈哈");
//		Base b = (Base) c;
//		b.AA();
//		new Base().AA();
//		String aa;
		//		List<String> l = new ArrayList<>();
		//		Map<String, String> m = new ConcurrentHashMap<>();
		//		int a = 1;
		//		l.parallelStream().filter(str -> {
		//			if (str != null) {
		//				return true;
		//			}
		//			m.put("d", "s");
		//			return false;
		//		}).collect(Collectors.toList());
		//		
		//		Node n = new Node();
		//		Thread t = new Thread() {
		//			/*
		//			 * (non-Javadoc)
		//			 * 
		//			 * @see com.springdemo.test.Mythread#run()
		//			 */
		//			@Override
		//			public void run() {
		//				// TODO Auto-generated method stub
		//				System.out.println("main");
		//				Node n1 = n.getNext();
		//				synchronized (n) {
		//					if (n1 == null) {
		//						try {
		//							n.wait();
		//						} catch (InterruptedException e) {
		//							// TODO Auto-generated catch block
		//							e.printStackTrace();
		//						}
		//					}
		//				}
		//				n1 = n.getNext();
		//				System.out.println(n1);
		//			}
		//		};
		//		t.start();
		//		new Thread() {
		//			/*
		//			 * (non-Javadoc)
		//			 * 
		//			 * @see com.springdemo.test.Mythread#run()
		//			 */
		//			@Override
		//			public void run() {
		//				// TODO Auto-generated method stub
		//				System.out.println("main");
		//				synchronized (n) {
		//					n.setNext(new Node());
		//					n.notifyAll();
		//				}
		//			}
		//		}.start();
		//Thread.sleep(100);
		/*
		 * Double d1 = new Double("2d"); Double d2 = new Double("2.00d"); System.out.println(d1.equals(d2)); System.out.println(d1.compareTo(d2));
		 * 
		 * BigDecimal bd1 = new BigDecimal("2.0"); BigDecimal bd2 = new BigDecimal("2.00"); System.out.println(bd1.equals(bd2)); System.out.println(bd1.compareTo(bd2));
		 *///		BigDecimal bd1 =new BigDecimal("2.0");
		//		BigDecimal bd2 = new BigDecimal("2.00");
		//		HashSet<BigDecimal> set1 = new HashSet<>();
		//		set1.add(bd1);
		//		set1.add(bd2);
		//		System.out.println(set1.size());
		//		TreeSet<BigDecimal> set2 = new TreeSet<>();
		//		set2.add(bd1);
		//		set2.add(bd2);
		//		System.out.println(set2.size());
		//
		//		TreeSet<Node> set3 = new TreeSet<>(new Comparator<Node>() {
		//
		//			@Override
		//			public int compare(Node o1, Node o2) {
		//				return Integer.compare(o1.getId(), o2.getId());
		//				//				if (o1.getId() - o2.getId() > 0) {
		//				//					return 1;
		//				//				} else if (o1.getId() - o2.getId() < 0) {
		//				//					return -1;
		//				//				} else {
		//				//					return 0;
		//				//				}
		//			}
		//		});
		//		Node n1 = new Node(Integer.MIN_VALUE);
		//		Node n2 = new Node(2);
		//		set3.add(n2);
		//		set3.add(n1);
		//		for (Node n : set3) {
		//			System.out.println(n.getId());
		//		}
		//		System.out.println("comparing BigDecimal using equals: " + bd1.equals(bd2));
		//		System.out.println("comparing BigDecimal using compareTo: " + bd1.compareTo(bd2));
		//		System.out.println(Double.POSITIVE_INFINITY == Double.POSITIVE_INFINITY);
		//		System.out.println(1d > Double.NaN);
		//		System.out.println(Double.compare(Double.NaN, 1d));
		//		System.out.println(Math.min(1d, Double.NaN));
		//		System.out.println("end");
		/*
		 * SyncTest s = new SyncTest(); Thread t1= new Thread(s); Thread t2= new Thread(s); t1.start(); t2.start(); NodeChild c = new NodeChild(); System.out.println(c); Byte a = 127 ; Byte b= 127 ; //int a =1281; //int b =1281; System.out.println(a==b); String s1 = "Programming"; String s2 = new String("Programming");
		 * String s3 = "Program" + "ming"; System.out.println(s1 == s2); System.out.println(s1 == s3); System.out.println(s1 == s1.intern()); short s =1; s +=1; System.out.println(s); Integer a=new Integer(127); Integer b=new Integer(127); System.out.println(a==b);
		 * 
		 * Node first = new Node(100); Node tmp = first;
		 * 
		 * for (int i = 0; i < 5; ++i) { Node b = new Node(i); tmp.setNext(b); tmp = b; } tmp = first; while (tmp != null) { System.out.print(tmp.getId() + ":"); tmp = tmp.getNext(); } System.out.println(); reverse(first);
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

class NodeChild extends Node {
	@Override
	public void testStatic() throws RuntimeException {
		System.out.println("Node testStatic executing");
	}

	@Override
	public boolean hasNext() {
		return true;
	}
}

class Node {
	private int id;
	private Node next;

	public void testStatic() throws NullPointerException {
		System.out.println("Node testStatic executing");
	}

	private void testPrivate() {
		System.out.println("Node testPrivate executing");
	}

	public Node() {
	}

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

class SyncTest implements Runnable {
	private int a = 10;

	@Override
	public void run() {
		try {
			while (a > 0) {
				Thread.sleep(1);
				a--;
				System.out.println(Thread.currentThread().getName() + ":" + a);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

class Mythread extends Thread {
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		System.out.println("mythread run");
	}
}

class Base {
	{
		System.out.println("base 代码块b");
	}
	static {
		System.out.println("base 静态代码块");
	}
	{
		System.out.println("base 代码块a");
	}
	public Base() {
		System.out.println("base");
	}
public Base(String str){
    System.out.println("base 有参");
}
	void AA() {
		System.out.println("base AA");
	}
}

class Child extends Base {
	static {
		System.out.println("child 静态代码块");
	}
	{
		System.out.println("child 代码块");
	}

	public Child() {
		System.out.println("child");
	}
public Child(String str){
    System.out.println("child 有参构造");
}
	void AA() {
		System.out.println("child AA");
	}
}