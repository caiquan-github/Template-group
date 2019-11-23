package cn.cq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName GoodsStart
 * @Auther: ToisKwon
 * @Date: 2019-11-24 02:40
 * @Description:
 */
@SpringBootApplication
@EnableEurekaClient
public class GoodsStart {
    public static void main(String[] args) {
        SpringApplication.run(GoodsStart.class,args);
    }

}
