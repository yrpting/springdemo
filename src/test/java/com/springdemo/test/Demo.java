/*
 * com.springdemo.test.Demo.java 
 * 中免（深圳）商务科技有限公司.
 * Copyright 2017 by www.zhongmian.com All rights reserved.
 * 
 */
package com.springdemo.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 *	日期		:	2017年1月6日<br>
 *	作者		:	rupeng.yan<br>
 *	项目		:	springdemo<br>
 *	功能		:	<br>
 */
class B {

    public void change(String str) {

        str = "HelloWorld";

    }

    public void c() throws Exception {
        throw new Exception();
    }
}

public class Demo {
    public static int block(){
        try{
            System.out.println("try block");
            throw new Exception();
        }catch(Exception e){
            System.out.println("exit block");
            System.exit(0);
            return 0;
        }finally{
            System.out.println("finally block");
            return 1;
        }
    }
    public static void main(String[] args){
        int i=0;
        i=block();
        System.out.println(i);
        //		String str = new String("good");
        //		char[] ch = { 'a', 'b', 'c' };
        //		change(str, ch);
        //		System.out.printChain(str + "and");
        //		System.out.printChain(ch);
        //        InputStream is = new InputStream() {
        //            
        //            @Override
        //            public int read() throws IOException {
        //                // TODO Auto-generated method stub
        //                return 0;
        //            }
        //        };
        //        Hashtable ht = new Hashtable();
        //        LinkedList ll = new LinkedList();
        //        int x = 0;
        //        int i = 1;
        //        do {
        //            if ((i % 5) == 0) {
        //                i++;
        //                continue;
        //            }
        //            x += ++i;
        //        } while (x < 100);
        //        System.out.println("x=" + x);
    }

    public Demo() {
        super();
        System.out.println("demo");
    }

    public void printxxx() {
        System.out.println("demo printxxx");
    }

    public static void change(String str, char[] ch) {
        str = "test ok";
        ch[0] = 'g';
    }
}

class Child11 extends Parent {
    private int x;
    private int y;

    public Child11(int x, int y) {
        super(x, y);
        this.y = y + 250;
        this.x = x + 150;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static void main(String[] args) {
        Child11 child = new Child11(100, 100);
        child.increaseX(100);
        child.increaseY(100);
        System.out.println("x=" + child.getX() + " and y=" + child.getY());
    }

}

class Parent {
    private int   x;
    protected int y;

    public Parent(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void increaseX(int x) {
        this.x = getX() + x;
    }

    public int getX() {
        return x;
    }

    public void increaseY(int y) {
        this.y = getY() + y;
    }

    public int getY() {
        return y;
    }
}

class StaticTest {
    private static int x = 1;

    public void increaseX(int increasement) {
        x += increasement;
    }

    public void printX() {
        System.out.println(x);
    }

    {
        System.out.println("hhh");
    }

    public StaticTest() {
        System.out.println("dddfasdf");
    }

    public StaticTest(int original) {
        increaseX(original);
        if (x > 10)
            x = 1;
    }

    public static void main(String[] args) {
        try {
            StaticTest st = (StaticTest) Class.forName("com.springdemo.test.StaticTest")
                .newInstance();
            //st.printX();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        StringBuilder word = new StringBuilder("Hello");
        getWho(word);
        System.out.println(word.toString());
    }

    public static void getWho(StringBuilder word) {
        word = word.append("  world");
    }
}

class SortedArrayList<T> implements SortedList<T> {
    Comparator<T>   c;
    private List<T> values;

    public SortedArrayList(Comparator<T> comparator) {
        this.c = comparator;
    }

    @Override
    public void add(T value) {
        if (values == null || values.size() <= 0) {
            values = new ArrayList<>();
            values.add(value);
            return;
        }

    }

    @Override
    public T get(int index) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }

    public static int BinarySearch(int[] datas, int i) {
        int len = datas.length;
        int b = 0, e = len - 1;
        int mid;
        for (;;) {
            if (b > e) {
                break;
            }
            mid = (b + e) / 2;
            if (datas[mid] == i) {
                return mid;
            }
            if (datas[mid] > i) {
                e = mid - 1;
            } else {
                b = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] datas = { 1, 3, 5 };
        System.out.println(BinarySearch(datas, 4));
        // System.out.println(getLoop(23,1889));
        Set<NodeLoop> set = new HashSet<>();
        NodeLoop n1 = new NodeLoop(1, 1);
        NodeLoop n2 = new NodeLoop(2, 2);
        NodeLoop n3 = new NodeLoop(3, 3);
        set.add(n1);
        set.add(n2);
        set.add(n3);
        n3.divide = 4;
        set.remove(n3);
        set.add(n3);

        ArrayList<String> strList = new ArrayList<>();
        strList.add("a");
        strList.add("b");
        //strList.add("c");
        //        Iterator<String> it = strList.iterator();
        //        while(it.hasNext()){
        //            if("c".equals(it.next())){
        //                it.remove();
        //            }
        //        }
        //        for(int i = 0;i<strList.size();++i){
        //            if("b".equals(strList.get(i))){
        //                strList.remove(strList.get(i));
        //            }
        //        }
        HashMap<String, String> map = new HashMap<>();
        for (String str : strList) {
            if ("b".equals(str)) {
                strList.remove(str);
            }
        }
        System.out.println(strList);
        //System.out.println(set);
        int a = 0;
        String s = "1";
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println(s);
            }
        }).start();
        //n1.divide=2;
    }

    public static String getLoop(int A, int B) {
        if (B == 0) {
            throw new ArithmeticException("divide can not be zero!");
        }
        if (A < 0)
            A = -A;
        if (B < 0)
            B = -B;
        int mod = Math.floorMod(A, B);
        if (mod == 0) {
            return "";
        }
        //存放余数和商
        Map<Integer, Integer> map = new HashMap<>();
        //存放商
        Stack<NodeLoop> quotients = new Stack<>();

        for (;;) {
            int divide = mod * 10;
            mod = Math.floorMod(divide, B);
            if (mod == 0) {
                return "";
            }
            if (map.containsKey(divide)) {
                NodeLoop node;
                StringBuffer ret = new StringBuffer();
                do {
                    node = quotients.pop();
                    ret.append(node.quotient);
                } while (node.divide != divide);
                return ret.reverse().toString();
            }
            int quotient = Math.floorDiv(divide, B);
            quotients.push(new NodeLoop(divide, quotient));
            map.put(divide, null);
        }
    }

    private static class NodeLoop {
        private int divide;
        private int quotient;

        public NodeLoop(int divide, int quotient) {
            this.divide = divide;
            this.quotient = quotient;
        }
    }
}
