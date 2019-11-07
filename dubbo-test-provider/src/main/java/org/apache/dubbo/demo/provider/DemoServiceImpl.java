package org.apache.dubbo.demo.provider;

import cn.caiquan.gmall.service.DemoService;

public class DemoServiceImpl implements DemoService{

	public String sayHello(String name) {
		return "hello "+name;
	}

}
