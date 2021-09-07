package com.caiquan.mybatis.mapper;

import com.caiquan.mybatis.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author kwon
 * @since 2021-08-13
 */
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from user where age = #{age}")
    public List<User> selectByAge(int age);

}
