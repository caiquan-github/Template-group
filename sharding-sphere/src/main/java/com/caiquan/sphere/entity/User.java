package com.caiquan.sphere.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import groovy.transform.EqualsAndHashCode;
import lombok.Data;
import lombok.experimental.Accessors;
 
/**
 * @Classname User
 * @Description 用户实体类
 * @Author 章国文 13120739083@163.com
 * @Date 2019-06-28 17:24
 * @Version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("user")
public class User extends Model<User> {
 
    /**
     * 主键Id
     */
    private int id;
 
    /**
     * 名称
     */
    private String name;
 
    /**
     * 年龄
     */
    private int age;
}
