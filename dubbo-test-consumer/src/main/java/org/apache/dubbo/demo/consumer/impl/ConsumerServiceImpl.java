package org.apache.dubbo.demo.consumer.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.caiquan.gmall.service.ConsumerService;
import cn.caiquan.gmall.service.DemoService;

@Service
public class ConsumerServiceImpl implements ConsumerService{

	@Autowired
	DemoService demoService;

	public String consumer() {
		System.out.println("1");
		return "输出调用结果 "+demoService.sayHello("caiquan");
		
	}
	
	
}
