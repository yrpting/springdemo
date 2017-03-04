package com.springdemo.test;

import java.util.ArrayList;
import java.util.Iterator;

public class ListTest {
public static void main(String[] args) {
    ArrayList<String> strList = new ArrayList<>();
    strList.add("a");
    strList.add("b");
    Iterator<String> it = strList.iterator();
    while(it.hasNext()){
        String str = it.next();
        if("b".equals(str)){
            strList.remove(str);
        }
    }
    System.out.println(strList);
//    for(String str:strList){
//        if("b".equals(str)){
//            strList.remove(str);
//        }
//    }
}
}
