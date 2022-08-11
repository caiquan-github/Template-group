package com.caiquan.spring.controler;

import com.caiquan.spring.controler.face.HelloControllerFace;
import com.caiquan.spring.controler.face.HelloControllerFace2;
import com.caiquan.spring.dto.TestDto;
import com.caiquan.spring.service.HelloService;
import com.caiquan.spring.service.WorkService;
import com.caiquan.spring.threadPool.ThreadPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author Kwon
 * @Title:
 * @Description:
 * @date 2020/3/2322:15
 */
@RestController("hello")
public class HelloController implements HelloControllerFace2 {
    @Autowired
    HelloService helloServiceImpl;

    @Autowired
    WorkService workService;

    @Override
    public String hello(){
        return helloServiceImpl.hello();
    }

    @Override
    public String test(@PathVariable("value")String value){
        return value;
    }

    @GetMapping("test")
    public String testet(TestDto testDto){
        testDto.toString();
        System.out.println(testDto.getTestValue());
        return "";
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
