package com.springdemo.test.executors;

import org.junit.Test;

import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class ExecutorsTest {
    @Test
    public void testExecutors(){
        Executors.newFixedThreadPool(10);
        Executors.newFixedThreadPool(1);
        Executors.newFixedThreadPool(1, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return null;
            }
        });
        ReentrantLock a = new ReentrantLock();
    }
}
