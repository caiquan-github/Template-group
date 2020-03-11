package com.caiquan;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogbackTest {

    public static final Logger LOGGER = LoggerFactory.getLogger(LogbackTest.class);


    // 快速入门
    @Test
    public void testQuick()throws Exception{


        //for (int i = 0; i < 10000; i++) {
            // 日志输出
            LOGGER.error("error");
            LOGGER.warn("wring");
            LOGGER.info("info");
            LOGGER.debug("debug");// 默认级别
            LOGGER.trace("trace");
       // }


    }
}