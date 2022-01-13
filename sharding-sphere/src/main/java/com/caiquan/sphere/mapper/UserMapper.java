package com.caiquan.sphere.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.caiquan.sphere.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * user dao层
 * @author lihaodong
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {


}