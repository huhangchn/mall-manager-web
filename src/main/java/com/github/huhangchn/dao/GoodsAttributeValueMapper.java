package com.github.huhangchn.dao;

import com.github.huhangchn.core.Mapper;
import com.github.huhangchn.model.GoodsAttributeValue;
import org.apache.ibatis.annotations.Delete;

public interface GoodsAttributeValueMapper extends Mapper<GoodsAttributeValue> {
    @Delete("delete from goods_attribute_value where goods_id = #{goodsId}")
    int deleteByGoodsId(Integer goodsId);
}