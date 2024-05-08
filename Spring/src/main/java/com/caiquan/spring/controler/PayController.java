package com.caiquan.spring.controler;

import com.caiquan.spring.service.PayService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("pay")
public class PayController implements InitializingBean, ApplicationContextAware {


    // 直接使用 @Autowired 也可以
    List<PayService> payServiceList=new ArrayList<>();

    @Autowired
    ApplicationContext applicationContext;

    @GetMapping("pay1/{code}")
    public String pay(@PathVariable("code") String code){
        for (PayService payService : payServiceList) {
            if (payService.supports(code)){
                payService.apy();
                break;
            }
        }

        return code;


    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Map<String, PayService> beansOfType = applicationContext.getBeansOfType(PayService.class);
        beansOfType.forEach((k,v)->{payServiceList.add(v);});

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }


}
