package com.caiquan.sphere.service.Impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.caiquan.sphere.entity.User;
import com.caiquan.sphere.mapper.UserMapper;
import org.springframework.stereotype.Service;
import com.caiquan.sphere.service.UserService;

import java.util.List;

/**
 * @Classname UserServiceImpl
 * @Description 用户服务实现类
 * @Author 章国文 13120739083@163.com
 * @Date 2019-06-28 17:32
 * @Version 1.0
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Override
    public boolean save(User entity) {
        return super.save(entity);
    }
 
    @Override
    public List<User> getUserList() {
        return baseMapper.selectList(Wrappers.<User>lambdaQuery());
    }
 
}
