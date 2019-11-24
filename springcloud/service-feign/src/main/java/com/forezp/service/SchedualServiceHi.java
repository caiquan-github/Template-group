package com.forezp.service;

import com.forezp.pojo.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.Serializable;

/**
 * Created by fangzhipeng on 2017/4/6.
 */
@FeignClient(value = "service-hi",fallback = SchedualServicelmpl.class)
public interface SchedualServiceHi {
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);

    @RequestMapping(value = "/haha",method = RequestMethod.GET)
    String sdsdaaaa(@RequestBody Book book);
}
