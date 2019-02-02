package com.github.huhangchn.service;
import com.github.huhangchn.model.GoodsAttributeValue;
import com.github.huhangchn.core.Service;

import java.util.List;


/**
* Created by CodeGenerator on 2019/02/01.
*/
public interface GoodsAttributeValueService extends Service<GoodsAttributeValue> {

    int deleteByGoodsId(Integer goodsId);

    /**
     *  拥有所有属性值的商品id列表
     */
    List<Integer> findGoodsIdsByAllValueIdList(List<Integer> valueIdsList);
}
