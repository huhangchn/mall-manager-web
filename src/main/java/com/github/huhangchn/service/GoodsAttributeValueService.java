package com.github.huhangchn.service;
import com.github.huhangchn.model.GoodsAttributeValue;
import com.github.huhangchn.core.Service;


/**
* Created by CodeGenerator on 2019/02/01.
*/
public interface GoodsAttributeValueService extends Service<GoodsAttributeValue> {

    int deleteByGoodsId(Integer goodsId);
}
