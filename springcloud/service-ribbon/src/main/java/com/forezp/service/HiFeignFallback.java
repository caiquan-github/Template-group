package com.forezp.service;

import org.springframework.stereotype.Component;

/**
 * @author aa3
 */
@Component
public class HiFeignFallback implements HiFeign {
    @Override
    public String haha(Book book) {
        return "系统异常";
    }
}
