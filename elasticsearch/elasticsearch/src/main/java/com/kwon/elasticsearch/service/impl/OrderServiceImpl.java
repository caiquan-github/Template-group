package com.kwon.elasticsearch.service.impl;

import com.kwon.elasticsearch.dto.PageResponse;
import com.kwon.elasticsearch.entity.Order;
import com.kwon.elasticsearch.repository.OrderRepository;
import com.kwon.elasticsearch.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    private ElasticsearchTemplate elasticsearchRestTemplate;

    @Override
    public void saveAll(List<Order> orders) {
        orderRepository.saveAll(orders);
    }

    @Override
    public void deleteById(Integer id) {
        orderRepository.deleteById(id);
    }

    @Override
    public void updateById(Order order) {
        orderRepository.save(order);
    }

    @Override
    public PageResponse<Order> findList(Order order, Integer pageIndex, Integer pageSize) {
        CriteriaQuery criteriaQuery = new CriteriaQuery(new Criteria()
                .and(new Criteria("orderDesc").contains(order.getOrderDesc()))
                .and(new Criteria("orderNo").is(order.getOrderNo())))
                .setPageable(PageRequest.of(pageIndex, pageSize));

        List<Order> orders = elasticsearchRestTemplate.queryForList(criteriaQuery, Order.class);

        PageResponse<Order> pageResponse = new PageResponse<Order>();
        pageResponse.setTotal(orders.size());
        pageResponse.setResult(orders);
        return pageResponse;
    }

    @Override
    public PageResponse<Order> findAll(Integer pageIndex, Integer pageSize) {
        Page<Order> page = orderRepository.findAll(PageRequest.of(pageIndex, pageSize));
        PageResponse<Order> pageResponse = new PageResponse<Order>();
        pageResponse.setTotal(page.getTotalElements());
        pageResponse.setResult(page.getContent());
        return pageResponse;
    }

    @Override
    public PageResponse<Order> findHighlight(Order order, Integer pageIndex, Integer pageSize) {
        if (order == null) {
            PageResponse<Order> pageResponse = new PageResponse<Order>();
            pageResponse.setTotal(0L);
            pageResponse.setResult(new ArrayList<>());
            return pageResponse;
        }

        CriteriaQuery criteriaQuery = new CriteriaQuery(new Criteria()
                .and(new Criteria("orderNo").is(order.getOrderNo()))
                .and(new Criteria("orderDesc").contains(order.getOrderDesc())))
                .setPageable(PageRequest.of(pageIndex, pageSize));

        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.field("orderNo").field("orderDesc");
        highlightBuilder.requireFieldMatch(false);
        highlightBuilder.preTags("<h3 >");
        highlightBuilder.postTags("</h3>");


        List<Order> orders = elasticsearchRestTemplate.queryForList(criteriaQuery, Order.class);



        PageResponse<Order> pageResponse = new PageResponse<Order>();
        pageResponse.setTotal(orders.size());
        pageResponse.setResult(orders);
        return pageResponse;
    }

    @Override
    public Order findById(Integer id) {
        return orderRepository.findById(id).orElse(null);
    }
}