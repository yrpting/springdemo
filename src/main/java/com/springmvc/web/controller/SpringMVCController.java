/*
 * com.springmvc.controller.SpringMVCController.java 
 * 中免（深圳）商务科技有限公司.
 * Copyright 2016 by www.zhongmian.com All rights reserved.
 * 
 */
package com.springmvc.web.controller;

import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.WebRequest;

import com.alibaba.fastjson.JSONArray;
import com.springmvc.model.User;
import com.springmvc.service.impl.SpringMVCServiceImpl;

/**
 * 日期 : 2016年11月22日<br>
 * 作者 : rupeng.yan<br>
 * 项目 : springdemo<br>
 * 功能 : <br>
 */
@Controller
@RequestMapping("/springdemo")
public class SpringMVCController {
	private Logger logger = LoggerFactory.getLogger(SpringMVCController.class);
	@Autowired
	private SpringMVCServiceImpl springMVCService;
	
	@RequestMapping(value="listusers")
	public String listUsers(Map<String, Object> map){
	    List<User> list = springMVCService.listUsers();
	    map.put("listUsers", list);
	    return "users";
	}

	@RequestMapping(value = "post")
	public String toPost(String str) {
		logger.info(str);
		springMVCService.getSomething(str);
		return "post";
	}

	@RequestMapping(params = { "aid=1", "aa=3", "ab!=22" }, value = { "/first/a{aid}", "/first1/{aid}" })
	public String firstController(HttpServletRequest request, @PathVariable(value = "aid") String aid, HttpServletResponse response, String param, Map<String, Object> map) {
		map.put("first", "你好");
		map.put("params", aid);
		//		try {
		//			Thread.sleep(1000l);
		//		} catch (InterruptedException e) {
		//			// TODO Auto-generated catch block
		//			e.printStackTrace();
		//		}
		//response.setHeader("Cache-Control", "max-age=0");
		logger.info("/first execute");
		springMVCService.getSomething(aid);
		return "first";
	}

	@RequestMapping("/postdemo")
	public String postdemo(HttpServletRequest request, @RequestParam("name") String name, @RequestParam("sex") String sex, Map<String, Object> map) {
		map.put("name", name);
		map.put("sex", sex);
		return "second";
	}

	@RequestMapping("/third")
	public String third(Model model, ModelMap map1, WebRequest webRequest, HttpServletRequest request, NativeWebRequest nativeWebRequest, String str, String third, Map<String, Object> map, Writer writer, boolean ret, HttpServletResponse response) {
		map.put("third", third);
		map.put("params", str);
		logger.info("webrequest's third:{}", webRequest.getParameter("third"));
		HttpServletRequest r = nativeWebRequest.getNativeRequest(HttpServletRequest.class);
		logger.info("一样否：{}", r == request);
		logger.info("Model ModelMap 一样否:{}", model == map1);
		logger.info("Model Map 一样否:{}", model == map);
		logger.info("ModelMap Map 一样否:{}", map1 == map);
		if (ret) {
			try {
				//				response.getWriter().write(str);
				writer.write(str);
				return null;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return "third";
	}
	@RequestMapping("/destroySession")
	public String destroySession(HttpServletRequest request){
	    request.getSession().invalidate();
	    return null;
	}
}
