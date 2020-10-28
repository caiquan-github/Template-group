package com.caiquan.hello.controller.impl;

import com.caiquan.hello.controller.HelloController;
import com.caiquan.hello.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Kwon
 * @Title:
 * @Description:
 * @date 2020/3/2322:15
 */
@RestController
public class HelloControllerImpl implements HelloController {
    @Autowired
    HelloService helloServiceImpl;

    @Override
    public String hello(){
        return helloServiceImpl.hello();
    }

}
