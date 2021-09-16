package com.example.springboottemplate.service;

import com.example.springboottemplate.entity.User;
import com.github.pagehelper.PageInfo;

import java.util.List;


public interface UserService {

    User getUserName(Integer id);

    Void createUser(User user);

    PageInfo<User> findAll(Integer pageNum, Integer pageSize);
}
