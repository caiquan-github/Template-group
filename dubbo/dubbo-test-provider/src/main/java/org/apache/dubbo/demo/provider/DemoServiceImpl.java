package org.apache.dubbo.demo.provider;

import org.springframework.stereotype.Service;

import cn.caiquan.gmall.service.DemoService;

@Service
public class DemoServiceImpl implements DemoService{

	public String sayHello(String name) {
		return "hello "+name;
	}

}
