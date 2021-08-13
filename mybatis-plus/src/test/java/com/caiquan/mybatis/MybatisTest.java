package com.caiquan.mybatis;

import com.caiquan.mybatis.entity.User;
import com.caiquan.mybatis.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author Kwon
 * @Title:
 * @Description:
 * @date 2021/8/1314:07
 */
@SpringBootTest

public class MybatisTest {
    @Autowired
    UserMapper userMapper;

    @Test
    public void foreachUser(){
        System.out.println("select all user info ");
        List<User> users = userMapper.selectList(null);

        users.forEach(System.out::println);


    }

}
