/*
 * com.springmvc.threadtest.Threads.java 
 * 中免（深圳）商务科技有限公司.
 * Copyright 2016 by www.zhongmian.com All rights reserved.
 * 
 */
package com.springmvc.threadtest;

import java.util.concurrent.Callable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *	日期		:	2016年12月6日<br>
 *	作者		:	rupeng.yan<br>
 *	项目		:	springdemo<br>
 *	功能		:	<br>
 */
public class Threads {
	private static Logger logger = LoggerFactory.getLogger(Threads.class);
	public static void main(String[] args) {
		Object a = 2, b = 1;
		DeadLockA da = new DeadLockA(a, b);
		DeadLockB db = new DeadLockB(a, b);
		new Thread(da).start();
		new Thread(db).start();
		//		logger.info("main thread {} begin", Thread.currentThread().getName());
		//		ExecutorService executor = Executors.newCachedThreadPool();
		//		Future<String> future = executor.submit(new Task());
		//		//		Future<String> future1 = executor.submit(new Task());
		//		executor.shutdown();
		//		//		logger.info("main thread {} end", Thread.currentThread().getName());
		//		try {
		//			Thread.sleep(100);
		//			System.out.println(future.cancel(false));
		//			logger.info("sub thread : interrupt result:{} {}", future.isCancelled(), future.isDone());
		//			//logger.info("sub thread1 :{} result", future1.get());
		//		} catch (Exception e) {
		//			// TODO Auto-generated catch block
		//			e.printStackTrace();
		//		}
		//		logger.info("main thread {} end2", Thread.currentThread().getName());

		//		FutureTask<String> futureTask = new FutureTask<>(new Task());
		//		//FutureTask<String> futureTask1 = new FutureTask<>(new Task());
		//		new Thread(futureTask).start();
		//		//new Thread(futureTask1).start();
		//		try {
		//			Thread.sleep(100);
		//			System.out.println(futureTask.cancel(false));
		//			logger.info("sub thread3 : interrupt result:{} {}", futureTask.isCancelled(), futureTask.isDone());
		//			//logger.info("sub thread4 :{} result:{} {}", futureTask1.get(), futureTask1.isCancelled(), futureTask1.isDone());
		//		} catch (InterruptedException e) {
		//			// TODO Auto-generated catch block
		//			e.printStackTrace();
		//		}
		//		logger.info("main thread {} end3", Thread.currentThread().getName());

	}
}

class Task implements Callable<String> {
	private Logger logger = LoggerFactory.getLogger(getClass());
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.concurrent.Callable#call()
	 */
	@Override
	public String call() throws Exception {
		String name = Thread.currentThread().getName();
		logger.info("sub thread：{} begin!", name);
		Thread.sleep(3000);
		logger.info("sub thread：{} is over!", name);
		return name;
	}

}

class DeadLockA implements Runnable {
	private Object a;
	private Object b;

	public DeadLockA(Object a, Object b) {
		this.a = a;
		this.b = b;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		synchronized (a) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized (b) {
				System.out.println("a,b");
			}
		}

	}
}

class DeadLockB implements Runnable {
	private Object a;
	private Object b;

	public DeadLockB(Object a, Object b) {
		this.a = a;
		this.b = b;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		synchronized (b) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized (a) {
				System.out.println("b,a");
			}
		}

	}
}