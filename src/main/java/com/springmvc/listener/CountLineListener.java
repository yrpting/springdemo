package com.springmvc.listener;

import java.util.Enumeration;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


public class CountLineListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        // TODO Auto-generated method stub
        Enumeration<?> es= se.getSession().getAttributeNames();
        while(es.hasMoreElements()){
            System.out.println(es.nextElement());
        }
        System.out.println("create:"+se.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        // TODO Auto-generated method stub
        System.out.println("destroy:"+se.getSession().getId());
    }

}
