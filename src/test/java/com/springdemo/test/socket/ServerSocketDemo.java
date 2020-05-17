package com.springdemo.test.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerSocketDemo {
    private static int PORT = 12345;

    private static ExecutorService executors = Executors.newFixedThreadPool(2);
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);
        while (true) {
            System.out.println("accepting....");
            Socket socket = serverSocket.accept();
            executors.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("handle " + Thread.currentThread().getName() + " at " + new Date());
                    try {
                        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                        String data = dataInputStream.readUTF();
                        String host = socket.getInetAddress().getHostAddress();
                        System.out.println(host + " said:" + data);
                        Thread.sleep(3000);
                        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                        dataOutputStream.writeUTF(Thread.currentThread().getName() + " said : hello! " + host);
                        dataOutputStream.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
