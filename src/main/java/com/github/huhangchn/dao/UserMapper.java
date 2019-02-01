package com.github.huhangchn.dao;

import com.github.huhangchn.core.Mapper;
import com.github.huhangchn.model.User;
import org.apache.ibatis.annotations.Select;

public interface UserMapper extends Mapper<User> {

    @Select(value = "select * from user where username = #{username}")
    User selectByUsername(String username);
}