package com.caiquan.spring.cloud.alibaba.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName HelloService
 * @Auther: ToisKwon
 * @Date: 2020-01-02 02:19
 * @Description:
 */
@FeignClient(value = "service-provider")
public interface HelloService {
    @GetMapping("/hello")
    public String hello();
}
