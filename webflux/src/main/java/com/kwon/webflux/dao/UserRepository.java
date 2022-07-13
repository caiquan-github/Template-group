package com.kwon.webflux.dao;

import com.kwon.webflux.dto.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UserRepository extends ReactiveCrudRepository<User,Integer> {

}