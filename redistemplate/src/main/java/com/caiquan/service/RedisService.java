package com.caiquan.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @description:
 * @author: cai quan
 * @create: 2019-11-29 10:44
 */
@RunWith(SpringRunner.class)
@SpringBootTest()
public class RedisService {
    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void test(){
        try {
            redisTemplate.opsForValue().set("1","我是储存的值");
        }catch (RedisConnectionFailureException r){
            System.out.println("网络连接异常");
        }


    }

    @Test
    public void test1(){
        try {
           redisTemplate.opsForValue().get("1");
        }catch (RedisConnectionFailureException r){
            System.out.println("网络连接异常");
        }
    }
}
