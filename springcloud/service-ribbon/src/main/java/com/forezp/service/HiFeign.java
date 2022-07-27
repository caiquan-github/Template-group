package com.forezp.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(name="SERVICE-HI",fallback=HiFeignFallback.class)
public interface HiFeign {

    @RequestMapping(value="/haha", method = RequestMethod.GET)
    public String haha (@RequestBody Book book);
}
