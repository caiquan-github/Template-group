package com.caiquan.mybatis.controller;


import com.caiquan.mybatis.entity.User;
import com.caiquan.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    private boolean save(@RequestBody User user){
        return userService.saveOrUpdate(user);
    }

    @GetMapping
    private User find(Integer id){
        return userService.getById(id);
    }
}

