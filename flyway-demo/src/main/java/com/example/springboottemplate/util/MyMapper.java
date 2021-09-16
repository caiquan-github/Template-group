package com.example.springboottemplate.util;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
    // 不可以与业务的mapper放在同一个目录，或者下级目录下
}
