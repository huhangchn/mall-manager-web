package com.github.huhangchn.dao;

import com.github.huhangchn.core.Mapper;
import com.github.huhangchn.model.Sku;
import org.apache.ibatis.annotations.Delete;

public interface SkuMapper extends Mapper<Sku> {
    @Delete("delete from sku where goods_id = #{goodsId}")
    int deleteByGoodsId(Integer goodsId);
}