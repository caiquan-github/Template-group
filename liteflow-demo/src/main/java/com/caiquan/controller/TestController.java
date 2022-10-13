package com.caiquan.controller;

import com.yomahub.liteflow.core.FlowExecutor;
import com.yomahub.liteflow.flow.LiteflowResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Kwon
 */
@RestController
public class TestController {

    @Resource
    private FlowExecutor flowExecutor;

    @GetMapping("test")
    public String test() {
        LiteflowResponse response = flowExecutor.execute2Resp("chain1", "arg");
        return "success";
    }
}
