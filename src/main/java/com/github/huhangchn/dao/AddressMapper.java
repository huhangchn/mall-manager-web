package com.github.huhangchn.dao;

import com.github.huhangchn.core.Mapper;
import com.github.huhangchn.model.Address;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AddressMapper extends Mapper<Address> {
    @Select("select * from address where user_id = #{userId}")
    List<Address> selectByUserId(Long userId);

    @Update("update address set is_Default = '0' where user_id = #{userId}")
    void setAddressDefaultFalse(Integer userId);
}