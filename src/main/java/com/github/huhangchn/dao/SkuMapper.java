package com.github.huhangchn.dao;

import com.github.huhangchn.core.Mapper;
import com.github.huhangchn.model.Sku;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SkuMapper extends Mapper<Sku> {
    @Delete("delete from sku where goods_id = #{goodsId}")
    int deleteByGoodsId(Integer goodsId);

    @Select("select * from sku where goods_id = #{goodsId}")
    List<Sku> selectByGoodsId(Integer goodsId);
}