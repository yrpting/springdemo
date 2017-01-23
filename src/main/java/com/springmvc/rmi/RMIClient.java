package com.springmvc.rmi;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.util.Scanner;

public class RMIClient {
    public static String url = "rmi://%s:1234/irmi";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        try {
            System.out.println("输入服务器ip:");
            url = String.format(url, s.next());
            IRMIInterface irmi = (IRMIInterface) Naming.lookup(url);
            System.out.println("和服务器说点话:");
            irmi.sayHello(s.next());
            System.out.println(irmi.getSomeThing("client"));
        } catch (NotBoundException | IOException e) {
            e.printStackTrace();
        } finally {
            s.close();
        }
    }
}
