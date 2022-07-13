package com.kwon.webflux.service;

import com.kwon.webflux.dao.UserRepository;
import com.kwon.webflux.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class UserServiceImpl {


    @Autowired
    private UserRepository adRepository;

    /**
     * 查询现在的的广告
     *
     * @return
     */
    public Flux<User> findAll() {

        return adRepository.findAll();
    }
}
