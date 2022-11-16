package com.kwon.elasticsearch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/index/")
@RestController
public class IndexController {

    @Autowired
    private ElasticsearchTemplate elasticsearchRestTemplate;

    /**
     * 创建索引
     */
    @GetMapping("create")
    public String create(@RequestParam String indexName) {
        boolean exists = elasticsearchRestTemplate.indexExists(indexName);
        if (exists) {
            return "索引已存在";
        }
        elasticsearchRestTemplate.createIndex(indexName);
        return "索引创建成功";
    }

    /**
     * 删除索引
     */
    @GetMapping("delete")
    public String delete(@RequestParam String indexName) {
        elasticsearchRestTemplate.deleteIndex(indexName);
        return "索引删除成功";
    }
}