/*
 * com.springmvc.threadtest.ProducerConsumer2.java 
 * 中免（深圳）商务科技有限公司.
 * Copyright 2016 by www.zhongmian.com All rights reserved.
 * 
 */
package com.springmvc.threadtest;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日期 : 2016年12月26日<br>
 * 作者 : rupeng.yan<br>
 * 项目 : springdemo<br>
 * 功能 : <br>
 */
public class ProducerConsumer2 {
	public static void main(String[] args) {
		Storage storage = new Storage(5);
		new Thread(new Producer(storage, 1), "制造1").start();
		new Thread(new Producer(storage, 2), "制造2").start();
		new Thread(new Producer(storage, 3), "制造3").start();
		new Thread(new Producer(storage, 4), "制造4").start();

		new Thread(new Consumer(storage, 1), "消费1").start();
		new Thread(new Consumer(storage, 2), "消费2").start();
		new Thread(new Consumer(storage, 3), "消费3").start();
		new Thread(new Consumer(storage, 4), "消费4").start();
	}
}

//class Storage {
//	/**
//	 * 利用Object的wait和notify实现
//	 */
//	private Logger logger = LoggerFactory.getLogger(Storage.class);
//	private List<Object> list;
//	private int max_len;
//
//	public Storage(int max_len) {
//		this.max_len = max_len;
//		list = new ArrayList<>(max_len);
//	}
//
//	public synchronized void produce(int num) {
//		String name = Thread.currentThread().getName();
//		while (list.size() + num > this.max_len) {
//			logger.info("{}:{}个装不下了，已经有{}个，稍等。。。", name, num, list.size());
//			try {
//				this.wait();
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//		for (int i = 0; i < num; i++) {
//			list.add(new Object());
//		}
//		logger.info("{}:制造了{}个,共{}个", name, num, list.size());
//		this.notifyAll();
//	}
//
//	public synchronized void consume(int num) {
//		String name = Thread.currentThread().getName();
//		while (list.size() < num) {
//			logger.info("{}:还有{}个，不够{}个了", name, list.size(), num);
//			try {
//				this.wait();
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//		for (int i = 0; i < num; i++) {
//			list.remove(0);
//		}
//		logger.info("{}:消费了{}个,还剩{}个", name, num, list.size());
//		this.notifyAll();
//	}
//}
//class Storage {
//	/**
//	 * 利用reentrantLock的Condition
//	 */
//	private Logger logger = LoggerFactory.getLogger(Storage.class);
//	private List<Object> list;
//	private int max_len;
//	private ReentrantLock lock = new ReentrantLock();
//	private Condition producerCond = lock.newCondition();
//	private Condition resumerCond = lock.newCondition();
//
//	public Storage(int max_len) {
//		this.max_len = max_len;
//		list = new ArrayList<>(max_len);
//	}
//
//	public void produce(int num) {
//		String name = Thread.currentThread().getName();
//		lock.lock();
//		while (list.size() + num > this.max_len) {
//			logger.info("{}:{}个装不下了，已经有{}个，稍等。。。", name, num, list.size());
//			try {
//				producerCond.await();
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//		for (int i = 0; i < num; i++) {
//			list.add(new Object());
//		}
//		logger.info("{}:制造了{}个,共{}个", name, num, list.size());
//		producerCond.signalAll();
//		resumerCond.signalAll();
//		lock.unlock();
//	}
//
//	public void consume(int num) {
//		String name = Thread.currentThread().getName();
//		lock.lock();
//		while (list.size() < num) {
//			logger.info("{}:还有{}个，不够{}个了", name, list.size(), num);
//			try {
//				resumerCond.await();
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//		for (int i = 0; i < num; i++) {
//			list.remove(0);
//		}
//		logger.info("{}:消费了{}个,还剩{}个", name, num, list.size());
//		producerCond.signalAll();
//		resumerCond.signalAll();
//		lock.unlock();
//	}
//}
class Storage {
	/**
	 * 利用blockingqueue
	 */
	private Logger logger = LoggerFactory.getLogger(Storage.class);
	private BlockingQueue<Object> queue;
	public Storage(int max_len) {
		queue = new ArrayBlockingQueue<>(max_len);
		queue = new LinkedBlockingQueue<>(max_len);
	}

	public void produce(int num) {
		String name = Thread.currentThread().getName();
		for(int i=0;i<num;++i){
			try {
				queue.put(new Object());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		logger.info("{}：生产了{}个,共{}个", name, num, queue.size());
	}

	public void consume(int num) {
		String name = Thread.currentThread().getName();
		for (int i = 0; i < num; ++i) {
			try {
				queue.take();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		logger.info("{}：消费了{}个,剩{}个", name, num, queue.size());
	}
}
class Producer implements Runnable {
	private Storage storage;
	private int num;

	public Producer(Storage storage, int num) {
		this.storage = storage;
		this.num = num;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		storage.produce(num);
	}
}

class Consumer implements Runnable {
	private Storage storage;
	private int num;

	public Consumer(Storage storage, int num) {
		this.storage = storage;
		this.num = num;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		storage.consume(num);
	}

}