package com.springmvc.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

import javax.script.ScriptException;

import com.springmvc.utils.Calculator;

/**
 * NIO 服务器端
 *                       
 * @Filename: NioServerHandle.java
 * @Version: 1.0
 * @Author: yanrp 燕如朋
 * @Email: 
 *
 */
public class NioServerHandle implements Runnable {
    private Selector            selector;
    private ServerSocketChannel serverSocketChannel;
    private volatile boolean    started;

    public NioServerHandle(int port) {

        try {
            selector = Selector.open();
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.socket().bind(new InetSocketAddress(port), 1024);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            started = true;
            System.out.println("服务器已启动，端口号：" + port);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void stop() {
        started = false;
    }

    @Override
    public void run() {
        while (started) {
            try {
                selector.select(1000);
                Set<SelectionKey> keys = selector.selectedKeys();
                Iterator<SelectionKey> it = keys.iterator();
                SelectionKey key = null;
                while (it.hasNext()) {
                    key = it.next();
                    it.remove();
                    try {
                        handleInput(key);
                    } catch (Exception e) {
                        key.cancel();
                        if (key.channel() != null)
                            key.channel().close();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (selector != null) {
            try {
                selector.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void handleInput(SelectionKey key) throws IOException {
        if (key.isValid()) {
            if (key.isAcceptable()) {
                ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
                SocketChannel sc = ssc.accept();
                sc.configureBlocking(false);
                sc.register(selector, SelectionKey.OP_READ);
            }
            if (key.isReadable()) {
                SocketChannel sc = (SocketChannel) key.channel();
                ByteBuffer buffer = ByteBuffer.allocate(1024);
                int readBytes = sc.read(buffer);
                if (readBytes > 0) {
                    buffer.flip();
                    byte[] bs = new byte[buffer.remaining()];
                    buffer.get(bs);
                    String expression= new String(bs,"UTF-8");
                    System.out.println("服务器收到消息：" + expression); 
                    String result = null;
                    try {
                        result = (String) Calculator.cal(expression);
                    } catch (ScriptException e) {
                        System.out.println("计算错误："+e.getMessage());
                    }
                    doWrite(sc,result);
                }else if(readBytes<0){
                    key.cancel();
                    sc.close();
                }
            }
        }
    }

    private void doWrite(SocketChannel channel, String response) throws IOException {
        byte[] bs=response.getBytes();
        ByteBuffer buffer = ByteBuffer.allocate(bs.length);
        buffer.put(bs);
        buffer.flip();
        channel.write(buffer);
    }
}
