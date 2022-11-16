package com.kwon;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


// TODO: 2022/11/16  没有测通 拿不到配置文件 
@SpringBootApplication
public class SpringCloudTencentConfigDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudTencentConfigDemoApplication.class, args);
    }

    @RestController
    @RefreshScope
    public static class UserController{

        @Value("${name:null1}")
        private String name;

        @GetMapping(value = "/name")
        public String name() {
            return name;
        }
    }
}
