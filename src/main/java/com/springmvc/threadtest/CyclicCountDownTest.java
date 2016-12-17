/*
 * com.springmvc.threadtest.CyclicCountDownTest.java 
 * 中免（深圳）商务科技有限公司.
 * Copyright 2016 by www.zhongmian.com All rights reserved.
 * 
 */
package com.springmvc.threadtest;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 *	日期		:	2016年12月17日<br>
 *	作者		:	rupeng.yan<br>
 *	项目		:	springdemo<br>
 *	功能		:	<br>
 */
public class CyclicCountDownTest {
	public static void main(String[] args) {
		CountDownLatch countDownLatch = new CountDownLatch(2);
		new Thread(new CountDownLatchTest(countDownLatch)).start();
		new Thread(new CountDownLatchTest(countDownLatch)).start();
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		CyclicBarrier cyclicBarrier = new CyclicBarrier(2, new Runnable() {
			public void run() {
				System.out.println("wait end");
			}
		});
		new Thread(new CyclicBarrierTest(cyclicBarrier)).start();
		new Thread(new CyclicBarrierTest(cyclicBarrier)).start();
		System.out.println("end at " + System.currentTimeMillis());

	}
}

class CountDownLatchTest implements Runnable {

	CountDownLatch countDownLatch;

	/**
	* 
	*/
	public CountDownLatchTest(CountDownLatch countDownLatch) {
		this.countDownLatch = countDownLatch;
	}

	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		System.out.println(name + ":before");
		this.countDownLatch.countDown();
		System.out.println(name + ":countdown at " + System.currentTimeMillis());
	}

}
class CyclicBarrierTest implements Runnable {
	CyclicBarrier cyclicBarrier;

	public CyclicBarrierTest(CyclicBarrier cyclicBarrier) {
		this.cyclicBarrier = cyclicBarrier;
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		System.out.println(name + ":wait...");
		try {
			cyclicBarrier.await();
		} catch (BrokenBarrierException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(name + ":executed");
	}

}
