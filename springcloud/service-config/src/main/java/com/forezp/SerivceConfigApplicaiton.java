package com.forezp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Created by Admin on 2019/11/25.
 */
@SpringBootApplication
@EnableConfigServer
public class SerivceConfigApplicaiton {
    public static void main(String[] args) {
        SpringApplication.run(SerivceConfigApplicaiton.class,args);
    }
}
