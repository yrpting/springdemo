package com.springmvc.nio;

public class NioServer {
    private static int DEFAULT_PORT = 12345;
    private static NioServerHandle serverHandle;
    public static void start(){
        start(DEFAULT_PORT);
    }
    private static synchronized void start(int port) {
        if(serverHandle!=null) serverHandle.stop();
        serverHandle = new NioServerHandle(port);
        new Thread(serverHandle).start();
    }
    public static void main(String[] args) {
        start();
    }
}
