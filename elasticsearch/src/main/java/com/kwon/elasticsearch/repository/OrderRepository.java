package com.kwon.elasticsearch.repository;

import com.kwon.elasticsearch.entity.Order;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


public interface OrderRepository extends ElasticsearchRepository<Order, Integer> {
}