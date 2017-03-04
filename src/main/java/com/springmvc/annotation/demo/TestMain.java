/*
 * com.springmvc.annotation.demo.TestMaim.java 
 * 中免（深圳）商务科技有限公司.
 * Copyright 2016 by www.zhongmian.com All rights reserved.
 * 
 */
package com.springmvc.annotation.demo;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日期 : 2016年12月4日<br>
 * 作者 : rupeng.yan<br>
 * 项目 : springdemo<br>
 * 功能 : <br>
 */
public class TestMain {
	private static Logger logger = LoggerFactory.getLogger(TestMain.class);
	@MyAnnotation(age = 20, gender = "M", id = 1, name = "zhangsan")
	private Object obj;

	public static void main(String[] args) throws Exception {
	    TreeMap treeMap = new TreeMap<>();
	   // treeMap.put(key, value);
	    LinkedHashMap hs = new LinkedHashMap<>();
	    //hs.put(key, value);
		Field field = TestMain.class.getDeclaredField("obj");
		ArrayList al =new ArrayList<>();
		//al.add(e);
		LinkedList ll = new LinkedList<>();
		//ll.add(e)
		Float f = 1f;
		float f1 =0/0f;
		System.out.println(Float.compare(0.00000001f, 0));
		System.out.println(f1);
        //		MyAnnotation annotation = field.getAnnotation(MyAnnotation.class);
        //		logger.info("age:{},gender:{},id:{},name:{}", annotation.age(), annotation.gender(), annotation.id(), annotation.name());
        //		Target t = annotation.annotationType().getAnnotation(Target.class);
        //		ElementType[] values = t.value();
        //
        //		Retention r = annotation.annotationType().getAnnotation(Retention.class);
        //		RetentionPolicy rps = r.value();
        //		logger.info("target:{},Retention:{}", values, rps);
        //		Method m = TestMain.class.getDeclaredMethod("toString");
        //	Annotation[] as = m.getAnnotations();
        //	System.out.println(as.length);
//		Override o =m.getAnnotation(Override.class);
//		System.out.println(o.annotationType());
	}
	@Override
    public String toString() {
        return "TestMain [obj=" + obj + "]";
    }
	
}
