package com.springdemo.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListTest {
public static void main(String[] args) {
    ArrayList<String> strList = new ArrayList<>();
    strList.add("a");
    strList.add("b");
    strList.add("c");
//    List<String> subList = strList.subList(0, 2);
//    System.out.println(subList);
//    strList.set(0, "aa");
//    System.out.println(subList);
//    subList.set(1, "bb");
//    System.out.println(subList);
//    System.out.println(strList);
    String[] aa = new String[strList.size()];
    strList.toArray(aa);
    System.out.println(aa);
    List<String> l = new ArrayList<>(Arrays.asList(aa));
    l.add("dd");
    System.out.println(l);
    System.out.println(aa.length);
    System.out.println(strList);
//    Iterator<String> it = strList.iterator();
//    while(it.hasNext()){
//        String str = it.next();
//        if("b".equals(str)){
//            strList.remove(str);
//        }
//    }
//    System.out.println(strList);
//    for(String str:strList){
//        if("b".equals(str)){
//            strList.remove(str);
//        }
//    }
}
}
