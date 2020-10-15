package com.springdemo.test;

import com.alibaba.fastjson.JSONObject;
import com.springmvc.inject.InjectClass1;
import com.springmvc.inject.InjectClass2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:spring/InjectTestXml.xml"})
public class TestInject {
    @Autowired
    private InjectClass1 injectClass1;
    @Autowired
    private InjectClass2 injectClass2;

    @Test
    public void testInject(){
//        System.out.println(injectClass1.getMymap() == injectClass2.getMymap());
//        System.out.println(injectClass1.getMylist() == injectClass2.getMylist());
        System.out.println(injectClass1.getMymap());
        injectClass1.getMymap().put(2,"aaaaaa");
        System.out.println(injectClass2.getMymap());
        System.out.println(injectClass1.getMymap());
//
//        injectClass1.getMylist().add("l3");
//        System.out.println(JSONObject.toJSONString(injectClass2.getMylist()));

    }
}
