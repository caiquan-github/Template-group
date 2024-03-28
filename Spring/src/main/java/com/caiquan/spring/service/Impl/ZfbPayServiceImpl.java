package com.caiquan.spring.service.Impl;

import com.caiquan.spring.service.PayService;
import org.springframework.stereotype.Service;

@Service
public class ZfbPayServiceImpl implements PayService {
    @Override
    public boolean supports(String code) {
        return "zfb".equals(code);
    }

    @Override
    public void apy() {
        System.out.println("zfb 支付");
    }
}
