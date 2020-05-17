package com.springdemo.test.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientSocketDemo {

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 3; ++i) {
            new Thread(new ClientTread()).start();
        }
    }
}

class ClientTread implements Runnable {
    private static int PORT = 12345;

    @Override
    public void run() {
        Socket socket = null;
        try {
            socket = new Socket("192.168.1.18", PORT);
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            outputStream.writeUTF("I'm " + Thread.currentThread().getName());
            outputStream.flush();
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            System.out.println(dis.readUTF());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}