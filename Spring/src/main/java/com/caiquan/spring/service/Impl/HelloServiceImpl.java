package com.caiquan.spring.service.Impl;

import com.caiquan.spring.service.HelloService;
import org.springframework.stereotype.Component;

/**
 * @author Kwon
 * @Title:
 * @Description:
 * @date 2020/3/2322:27
 */
@Component
public class HelloServiceImpl implements HelloService {


    public String hello() {
        return "st";
    }
}
