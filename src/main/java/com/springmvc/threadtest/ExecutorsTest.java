package com.springmvc.threadtest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class ExecutorsTest {
    public static void main(String[] args) {
         ExecutorService ess= Executors.newFixedThreadPool(2);
        //Executors.newCachedThreadPool();
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
        //for (int i = 0; i < 5; ++i) {
            ses.scheduleAtFixedRate(new Runnable() {

                @Override
                public void run() {
                    try {
                        String name = Thread.currentThread().getName();
                        System.out.println(name + ":running");
                        Thread.sleep(3000);
                        System.out.println(name + ":stoped");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, 0, 2, TimeUnit.SECONDS);
            //            ses.execute(new Runnable() {
            //                
            //                @Override
            //                public void run() {
            //                    try {
            //                        String name = Thread.currentThread().getName();
            //                        System.out.println(name+":running");
            //                        Thread.sleep(1000);
            //                    } catch (Exception e) {
            //                        // TODO Auto-generated catch block
            //                        e.printStackTrace();
            //                    }
            //                }
            //            });
        }
     //   ses.shutdown();
   // }
}
