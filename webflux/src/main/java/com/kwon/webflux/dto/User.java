package com.kwon.webflux.dto;


import org.springframework.data.relational.core.mapping.Table;

@Table("user_0")
public class User {

    /**
     * 姓名
     */
    private String name;

    private Integer age;

    /**
     * 描述
     */
    private String desc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
