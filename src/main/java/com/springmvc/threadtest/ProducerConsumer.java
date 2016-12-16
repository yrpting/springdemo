/*
 * com.springmvc.threadtest.Producer.java 
 * 中免（深圳）商务科技有限公司.
 * Copyright 2016 by www.zhongmian.com All rights reserved.
 * 
 */
package com.springmvc.threadtest;

/**
 * 日期 : 2016年12月15日<br>
 * 作者 : rupeng.yan<br>
 * 项目 : springdemo<br>
 * 功能 : <br>
 */
public class ProducerConsumer {
	public static void main(String[] args) {
		Resource resource = new Resource();
		new Thread(new Producer(resource)).start();
		new Thread(new Consumer(resource)).start();
	}
}

class Producer implements Runnable {
	private Resource resource;

	public Producer(Resource resource) {
		this.resource = resource;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		int i = 0;
		while (true) {
			synchronized (resource) {
				if (resource.isFlag() == true) {
					try {
						if ((i++) % 2 == 0) {
							this.resource.setId(1);
							this.resource.setName("I'm one");
						} else {
							this.resource.setId(2);
							this.resource.setName("I'm two");
						}
						resource.setFlag(false);
						resource.notify();
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					try {
						resource.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		}
	}
}

class Consumer implements Runnable {
	private Resource resource;

	public Consumer(Resource resource) {
		this.resource = resource;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized (resource) {
				if (resource.isFlag() == false) {
					if (resource != null) {
						System.out.println(resource.getId() + ":" + resource.getName());
					} else {
						System.out.println("resouce is null");
					}
					resource.setFlag(true);
					resource.notify();
				} else {
					try {
						resource.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}

}

class Resource {
	private int id;
	private String name;

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	private boolean flag;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
