package com.caiquan.spring.service;

import org.springframework.stereotype.Service;

public interface PayService {
    boolean supports(String code);
    void apy();
}
