package com.caiquan.spring.service.Impl;

import com.caiquan.spring.service.PayService;
import org.springframework.stereotype.Service;

@Service
public class VxPayServiceImpl implements PayService {
    @Override
    public boolean supports(String code) {
        return "vx".equals(code);
    }

    @Override
    public void apy() {
        System.out.println("vx支付");
    }
}
