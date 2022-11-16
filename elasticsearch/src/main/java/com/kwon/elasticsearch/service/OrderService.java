package com.kwon.elasticsearch.service;

import com.kwon.elasticsearch.dto.PageResponse;
import com.kwon.elasticsearch.entity.Order;

import java.util.List;

public interface OrderService {
    void saveAll(List<Order> orders);

    Order findById(Integer id);

    void deleteById(Integer id);

    void updateById(Order order);

    PageResponse<Order> findList(Order order, Integer pageIndex, Integer pageSize);

    PageResponse<Order> findAll(Integer pageIndex, Integer pageSize);

    PageResponse<Order> findHighlight(Order order, Integer pageIndex, Integer pageSize);
}