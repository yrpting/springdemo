package com.springdemo.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.util.zip.GZIPOutputStream;

public class NULL {
    String str=new String("good");
    char[] ch = {'a','b','c'};
public static void haha(){
    System.out.println("haha");
}
public void changge(String str,char ch[]) throws IndexOutOfBoundsException{
    str="test ok";
    ch[0]='g';
}
public static void main(String[] args) {
  NULL n = new NULL();
  n.changge(n.str, n.ch);
  System.out.print(n.str+" and ");
  System.out.println(n.ch);
    //System.out.println((NULL)null);
//    try {
//        new BufferedWriter(new FileWriter("a.txt"));
//        new BufferedReader(new InputStreamReader(new FileInputStream("a.dat")));
//        new GZIPOutputStream(new FileOutputStream("a.zip"));
//        new ObjectInputStream(new FileInputStream("a.txt"));
//    } catch (IOException e) {
//        // TODO Auto-generated catch block
//        e.printStackTrace();
//    }
    System.out.println("5"+2);
    new NULL().getCustomerInfo();
}
public void getCustomerInfo(){
    try{
        throw new IOException();
    }catch(FileNotFoundException e){
        System.out.println("FileNotFoundException");
    }catch(IOException e){
        System.out.println("IOException");
    }catch(Exception e){
        System.out.println("Exception");
    }
}
}
