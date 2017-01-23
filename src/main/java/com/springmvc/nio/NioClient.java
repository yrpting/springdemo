package com.springmvc.nio;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;

import com.sun.jmx.snmp.tasks.ThreadService;

public class NioClient {
    private static String       DEFAULT_HOST = "127.0.0.1";
    private static int          DEFAULT_PORT = 12345;
    private static ClientHandle clientHandle;

    public static synchronized void start() {
        if (clientHandle != null)
            clientHandle.stop();
        clientHandle=new ClientHandle(DEFAULT_HOST,DEFAULT_PORT);
        new Thread(clientHandle,"client").start();
       // ThreadMXBean mxBean;
    }
    public static void main(String[] args) {
        int oldCapacity=2;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        System.out.println(newCapacity);
        Executors.newFixedThreadPool(100);
    }
}
