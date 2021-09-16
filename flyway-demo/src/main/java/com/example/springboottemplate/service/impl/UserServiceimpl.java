package com.example.springboottemplate.service.impl;

import com.example.springboottemplate.entity.User;
import com.example.springboottemplate.mapper.UserMapper;
import com.example.springboottemplate.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceimpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserName(Integer id) {
        User user = new User();
        user.setId(id);
        user = userMapper.selectOne(user);
        return user;
    }

    @Override
    public Void createUser(User user) {
        return null;
    }

    @Override
    public PageInfo<User> findAll(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<User> pageInfo = new PageInfo(userMapper.findAll());
        return pageInfo;
    }
}
