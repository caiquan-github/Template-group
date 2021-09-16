package com.example.springboottemplate.dto.common;


public class Result<T> {

    private Integer code;
    private String message;
    private String trace;
    private T res;


    private Result(Integer code, String message, String trace, T res) {
        this.code = code;
        this.message = message;
        this.trace = trace;
        this.res = res;
    }

    // 建造者模式，便于构建返回体
    public static <T> ResultBuilder<T> builder() {
        return new ResultBuilder();
    }

    public static class ResultBuilder<T> {
        private Integer code;
        private String message;
        private String trace;
        private T res;

        public ResultBuilder<T> code(Integer code) {
            this.code = code;
            return this;
        }

        public ResultBuilder<T> message(String message) {
            this.message = message;
            return this;
        }

        public ResultBuilder<T> trace(String trace) {
            this.trace = trace;
            return this;
        }

        public ResultBuilder<T> res(T res) {
            this.res = res;
            return this;
        }

        public Result<T> build() {
            return new Result(code, message, trace, res);
        }
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTrace() {
        return trace;
    }

    public void setTrace(String trace) {
        this.trace = trace;
    }

    public T getRes() {
        return res;
    }

    public void setRes(T res) {
        this.res = res;
    }
}
