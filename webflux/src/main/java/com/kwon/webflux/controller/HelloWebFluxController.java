package com.kwon.webflux.controller;

import com.kwon.webflux.dto.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author Kwon
 */
@RestController
public class HelloWebFluxController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello, WebFlux !";
    }

    @GetMapping("/user")
    public Mono<User> getUser() {
        User user = new User();
        user.setName("name 1");
        user.setDesc("1111111111111111");
        return Mono.just(user);
    }


}
