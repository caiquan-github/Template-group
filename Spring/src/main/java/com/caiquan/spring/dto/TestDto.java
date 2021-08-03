package com.caiquan.spring.dto;

/**
 * @author Kwon
 * @Title:
 * @Description:
 * @date 2021/7/1911:55
 */
public class TestDto {
    private String testValue;

    public TestDto(String bas){
        this.testValue=bas;
        System.out.println("调用构造器");
    }

    public String getTestValue() {
        return testValue;
    }

    public void setTestValue(String testValue) {
        this.testValue = testValue;
    }
}
