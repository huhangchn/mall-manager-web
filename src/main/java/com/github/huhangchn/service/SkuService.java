package com.github.huhangchn.service;
import com.github.huhangchn.model.Sku;
import com.github.huhangchn.core.Service;


/**
* Created by CodeGenerator on 2019/01/29.
*/
public interface SkuService extends Service<Sku> {

    int deleteByGoodsId(Integer goodsId);
}
