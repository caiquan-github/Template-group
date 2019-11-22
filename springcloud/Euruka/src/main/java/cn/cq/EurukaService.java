package cn.cq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by Admin on 2019/11/22.
 */
@SpringBootApplication
@EnableEurekaServer
public class EurukaService {
        public static void main(String[] args) {
            SpringApplication.run(EurukaService.class, args);
        }
}
