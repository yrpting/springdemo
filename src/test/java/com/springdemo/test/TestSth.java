package com.springdemo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.util.StopWatch;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

//@RunWith(JUnit4.class)
public class TestSth {
    @Test
    public void test() throws BrokenBarrierException, InterruptedException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Long sum = 0L;
        for (long l = 0; l < Integer.MAX_VALUE; ++l) {
            sum += l;
        }
        stopWatch.stop();
        System.out.println(stopWatch.getLastTaskTimeMillis());
        stopWatch.start();
        long sum1 = 0;
        for (long l = 0; l < Integer.MAX_VALUE; ++l) {
            sum1 += l;
        }
        stopWatch.stop();
        System.out.println(stopWatch.getLastTaskTimeMillis());

        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.putIfAbsent("d", "d");

    }

    private static AtomicLong aLong = new AtomicLong();
    //    static Thread t = new Thread(()->{
//        aLong.getAndIncrement();
//        System.out.println("111");
//    },"test");
    static Thread t = new Thread(new Runnable() {
        @Override
        public void run() {
            aLong.getAndIncrement();
            System.out.println("111 ");
        }
    }, "test");

    static {
        System.out.println("static");
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        System.out.println("ok");
    }
}
