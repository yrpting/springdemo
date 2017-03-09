package com.springdemo.test.algorithm;

import java.util.HashSet;
import java.util.Set;

public class FindSamePointer {
    public static void main(String[] args) {
        Node n1= new Node();
        Node n2= new Node();
        Node n3= new Node();
        Node t1= new Node();
        Node t2= new Node();
        Node t3= new Node();
        
        n1.next=n2;
        n2.next=n3;
        
        t1.next = n2;
        t2.next = t3;
        
        Set<Node> s = new HashSet<>();
        s.add(n1);
        Node tmp = n1.next;
        do{
            s.add(tmp);
            tmp = tmp.next;
        }while(tmp!=null);
        
        s.add(t1);
        tmp = t1.next;
        do{
            s.add(tmp);
            tmp = tmp.next;
        }while(tmp!=null);
        System.out.println(s.size());
    }
}
class Node{
    public Node next;
}