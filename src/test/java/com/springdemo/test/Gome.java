package com.springdemo.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;

public class Gome {
    private static int func(){
        int i,j,k=0;
        for(i=0,j=-1;j==0;i++,j++){
            k++;
        }
        return k;
    }
    private static int getMost(int[][] board){
        System.out.println(board[0].length);
        return 0;
    }
    public static void main(String[] args) {
        int[][] board = {{1,2,3},{4,5,6}};
        System.out.println(getMost(board));
        
        //        String str1= "hello";
        //        String str2 = "he"+new String("llo");
        //        System.out.println(str1==str2.intern());
        //   Child1 c= new Child1("mike");
        // System.out.println( c.Child1());
        //        HashMap<String, String> h = new HashMap<>();
        //        h.put("aaa", "ddd2");
        //        h.put("aaa", "ddd");
        //      System.out.println(  h.put("aaa", "ddd1"));
        //      System.out.println(  h.put("aaaa", "ddd1"));
        //h.put(null, null);
        //        h.put(null, "d");
        //
        //        System.out.println(h.get(null));
        //        Hashtable<String, String> ht = new Hashtable<>();
        //        ht.put(null, "a");
        //Circle c = new Circle();
        //c.name="ssssname";
        //c.color=1;
        //c.type="s";
        //c.setRadius(1111f);
        //try {
        //    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d:/circle.obj"));
        //oos.writeObject(c);
        //oos.close();
        //ObjectInputStream ois =new ObjectInputStream(new FileInputStream("d:/circle.obj"));
        //Circle cc=(Circle)(ois.readObject());
        //ois.close();
        //System.out.println(cc.name+cc.color+cc.type+cc.getRadius());
        //Field f = Circle.class.getDeclaredField("radius");
        //f.setAccessible(true);
        //System.out.println(f.get(cc));
        //} catch (IOException | ClassNotFoundException | NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
        //    // TODO Auto-generated catch block
        //    e.printStackTrace();
        //}
    }
}

class Shape implements Serializable {
    /**
     *Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 8904508683708194696L;
    public String             name;
}

class Circle extends Shape implements Serializable {
    private float        radius = 11f;
    transient int        color;
    public static String type   = "Circle";

    public float getRadius() {
        return radius;
    }

    public void setRadius(float r) {
        this.radius = r;
    }
}

class People {
    String name;

    public People() {
        System.out.println(1);
    }

    public People(String name) {
        System.out.println(2);
        this.name = name;
    }
}

class Child1 extends People {
    People father;

    public Child1(String name) {
        System.out.println(3);
        this.name = name;
        father = new People(name);
    }

    public Child1() {
        System.out.println(4);
    }

    public String Child1() {
        return name;
    }
}