package com.caiquan.mybatis.controller;


import com.caiquan.mybatis.entity.User;
import com.caiquan.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author kwon
 * @since 2021-08-13
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public boolean save(@RequestBody User user){
        return userService.saveOrUpdate(user);
    }

    @GetMapping
    @Transactional
    public User find(Integer id) throws InterruptedException {
        System.out.println(userService.getById(id).getName());
        Thread.sleep(10000);
        System.out.println(userService.getById(id).getName());
        return userService.getById(id);
    }

    @GetMapping("s")
    @Transactional
    public List<User> finds() throws InterruptedException {
        System.out.println(userService.getBaseMapper().selectList(null));
        Thread.sleep(20000);
        System.out.println(userService.getBaseMapper().selectList(null));
        return userService.getBaseMapper().selectList(null);
    }
}

