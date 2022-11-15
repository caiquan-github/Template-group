package com.kwon.elasticsearch.controller;

import com.alibaba.fastjson.JSON;
import com.kwon.elasticsearch.dto.PageResponse;
import com.kwon.elasticsearch.entity.Order;
import com.kwon.elasticsearch.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/doc/")
@RestController
public class DocController {

    @Autowired
    OrderService orderService;

    /**
     * 批量创建
     */
    @PostMapping("saveBatch")
    public String saveBatch(@RequestBody List<Order> orders) {
        if (CollectionUtils.isEmpty(orders)) {
            return "文档不能为空";
        }
        orderService.saveAll(orders);
        return "保存成功";
    }

    /**
     * 根据id删除
     */
    @GetMapping("deleteById")
    public String deleteById(@RequestParam Integer id) {
        orderService.deleteById(id);
        return "删除成功";
    }

    /**
     * 根据id更新
     */
    @PostMapping("updateById")
    public String updateById(@RequestBody Order order) {
        orderService.updateById(order);
        return "更新成功";
    }

    /**
     * 根据id搜索
     */
    @GetMapping("findById")
    public String findById(@RequestParam Integer id) {
        return JSON.toJSONString(orderService.findById(id));
    }

    /**
     * 分页搜索所有
     */
    @GetMapping("findAll")
    public String findAll(@RequestParam Integer pageIndex, @RequestParam Integer pageSize) {
        PageResponse<Order> all = orderService.findAll(pageIndex, pageSize);
        return JSON.toJSONString(all);
    }

    /**
     * 条件分页搜索
     */
    @GetMapping("findList")
    public String findList(@RequestBody Order order, @RequestParam Integer pageIndex, @RequestParam Integer pageSize) {
        return JSON.toJSONString(orderService.findList(order, pageIndex, pageSize));
    }

    /**
     * 条件高亮分页搜索
     */
    @GetMapping("findHighlight")
    public String findHighlight(@RequestBody(required = false) Order order, @RequestParam Integer pageIndex, @RequestParam Integer pageSize) {
        return JSON.toJSONString(orderService.findHighlight(order, pageIndex, pageSize));
    }
}