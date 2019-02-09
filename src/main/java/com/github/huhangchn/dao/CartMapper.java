package com.github.huhangchn.dao;

import com.github.huhangchn.core.Mapper;
import com.github.huhangchn.dto.CartDto;
import com.github.huhangchn.model.Cart;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CartMapper extends Mapper<Cart> {
    List<CartDto> selectCartList(Integer userId);

    @Update("update cart set num=#{num},checked=#{checked} where user_id=#{userId} and sku_id=#{skuId}")
    int updateByUserIdAndSkuId(Integer userId, Integer skuId, Integer num, String checked);

    @Update("update cart set checked=#{checked} where user_id=#{userId}")
    int updateCheckedByUserId(Integer userId, String checked);

    @Delete("delete from cart where checked='1' and user_id=#{userId}")
    int deleteCheckedByUserId(Integer userId);

    @Delete("delete from cart where user_id=#{userId} and sku_id=#{skuId}")
    int deleteByUserIdAndSkuId(Integer userId, Integer skuId);

    @Select("select count(id) from cart where user_id=#{userId} and sku_id=#{skuId}")
    int countByUserIdAndSkuId(Integer userId, Integer skuId);

    @Update("update cart set num=num+#{num} where user_id=#{userId} and sku_id=#{skuId}")
    int addNumByUserIdAndSkuId(Integer userId, Integer skuId, Integer num);
}