package com.caiquan;

import org.junit.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Slf4jTest {

    public static final Logger logger=LoggerFactory.getLogger(Slf4jTest.class);

    @Test
    public void test(){
        // 日志输出
        logger.error("error");
        logger.warn("wring");
        logger.info("info"); // 默认级别
        logger.debug("debug");
        logger.trace("trace");

        // 使用占位符输出日志信息
        String name = "itheima";
        Integer age = 14;
        logger.info("用户：{},{}",name,age);

        // 将系统的异常信息输出
        try {
            int i = 1/0;
        } catch (Exception e) {
            // e.printStackTrace();
            logger.error("出现异常：",e);
        }

    }
}
