package com.example.springboottemplate.dto.common;

public enum ResultCode {

    SUCCESS(1, "success"),
    ERROR(0, "error");

    private Integer code;
    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer code() {
        return code;
    }

    public String message() {
        return message;
    }


}
