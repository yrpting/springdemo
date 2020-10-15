package com.springdemo.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.omg.CORBA.INTERNAL;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RunWith(JUnit4.class)
public class ExchangeTest {

    @Test
    public void exchange() throws InterruptedException {
        Exchanger exchanger = new Exchanger<String>();
        int count = 2;
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        executorService.execute(new MyExchanger<String>(exchanger, "str1"));
        List<String> list = new ArrayList();
        list.add("hhhh");
        list.add("asdfsfdsf");
        executorService.execute(new MyExchanger<List>(exchanger, list));

        executorService.execute(new MyExchanger<String>(exchanger,"str2"));
        executorService.execute(new MyExchanger<String>(exchanger,"str333"));

        Thread.sleep(10000);
    }
}

class MyExchanger<T> implements Runnable {
    private Exchanger<T> exchanger;
    private T data;

    MyExchanger(Exchanger<T> exchanger, T data) {
        this.exchanger = exchanger;
        this.data = data;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "=>before data:" + data);
        try {
            data = this.exchanger.exchange(data);
            System.out.println(Thread.currentThread().getName() + "=>after data:" + data);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
