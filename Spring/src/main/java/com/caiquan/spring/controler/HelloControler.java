package com.caiquan.spring.controler;

import com.caiquan.spring.service.HelloService;
import com.caiquan.spring.service.WorkService;
import com.caiquan.spring.threadPool.ThreadPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Kwon
 * @Title:
 * @Description:
 * @date 2020/3/2322:15
 */
@Controller
public class HelloControler {
    @Autowired
    HelloService helloServiceImpl;

    @Autowired
    WorkService workService;

    @GetMapping("hello")
    @ResponseBody
    public String hello(){
        return helloServiceImpl.hello();
    }

    @GetMapping("test/{value}/add")
    @ResponseBody
    public String test(@PathVariable("value") String value){
        return value;
    }

    @Autowired
    public void testAuto() throws InterruptedException {
        ThreadPool.es.submit(()->{
            System.out.println("测试自动11111");
            System.out.println(workService.test());
            try {
                Thread.sleep(223000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

    }

}
