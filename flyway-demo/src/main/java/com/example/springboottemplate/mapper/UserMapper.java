package com.example.springboottemplate.mapper;

import com.example.springboottemplate.entity.User;
import com.example.springboottemplate.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper//指定这是一个操作数据库的mapper
public interface UserMapper extends MyMapper<User> {
    List<User> findAll();
}