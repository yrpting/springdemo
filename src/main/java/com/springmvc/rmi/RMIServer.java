package com.springmvc.rmi;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.RMISocketFactory;
import java.rmi.server.ServerNotActiveException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

/**
 * 服务器端
 *                       
 * @Filename: RMIServer.java
 * @Version: 1.0
 * @Author: yanrp 燕如朋
 * @Email: 
 *
 */
public class RMIServer extends UnicastRemoteObject implements IRMIInterface {
    public static String      url              = "rmi://%s:1234/irmi";
    /**
     *Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -7279580357318512456L;

    protected RMIServer() throws RemoteException {
        super();
    }

    @Override
    public void sayHello(String name) throws RemoteException {
        try {
            String host = getClientHost();
            String ip = InetAddress.getByName(host).getHostAddress();
            System.out.println("host:" + host);
            System.out.println("ip:" + ip + "-->welcome:" + name);
        } catch (ServerNotActiveException | UnknownHostException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getSomeThing(String name) throws RemoteException {
        String ret = "";
        try {
            String ip = InetAddress.getByName(getClientHost()).getHostAddress();
            ret = "ip:" + ip + "-->" + name + ":你好,给你" + (int) (Math.random() * 100);
        } catch (UnknownHostException | ServerNotActiveException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        try {
            System.out.println("输入ip(localhost输入1):");
            String ip = s.next();
            if ("1".equals(ip)) {
                ip = "localhost";
            }
            url = String.format(url, ip);
            System.out.println(url);
            //System.setProperty("java.rmi.server.hostname", "192.168.1.15");
            CustomRMISocketFactory socketFactory = new CustomRMISocketFactory(12345);
            RMISocketFactory.setSocketFactory(socketFactory);
            IRMIInterface irmi = new RMIServer();
            LocateRegistry.createRegistry(1234);
            Naming.bind(url, irmi);
            System.out.println(">>>>>>远程RMI绑定成功");
        } catch (AlreadyBoundException | IOException e) {
            e.printStackTrace();
        } finally {
            s.close();
        }
    }
}

/**
 * SocketFactory 指定Socket端口工厂类
 *                       
 * @Filename: RMIServer.java
 * @Version: 1.0
 * @Author: yanrp 燕如朋
 * @Email: 
 *
 */
class CustomRMISocketFactory extends RMISocketFactory {
    private int p;

    CustomRMISocketFactory(int port) {
        this.p = port;
    }

    @Override
    public Socket createSocket(String host, int port) throws IOException {
        if (port == 0) {
            port = this.p;
        }
        return new Socket(host, port);
    }

    @Override
    public ServerSocket createServerSocket(int port) throws IOException {
        if (port == 0) {
            port = this.p;
        }
        return new ServerSocket(port);
    }

}
