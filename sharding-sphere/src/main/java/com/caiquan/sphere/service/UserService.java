package com.caiquan.sphere.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.caiquan.sphere.entity.User;

import java.util.List;

/**
 * @Classname UserService
 * @Description 用户服务类
 * @Author 章国文 13120739083@163.com
 * @Date 2019-06-28 17:31
 * @Version 1.0
 */
public interface UserService extends IService<User> {
 
    /**
     * 保存用户信息
     * @param entity
     * @return
     */
    @Override
    boolean save(User entity);
 
    /**
     * 查询全部用户信息
     * @return
     */
    List<User> getUserList();
}
