package com.github.huhangchn.service;
import com.github.huhangchn.model.Sku;
import com.github.huhangchn.core.Service;

import java.util.List;


/**
* Created by CodeGenerator on 2019/01/29.
*/
public interface SkuService extends Service<Sku> {

    int deleteByGoodsId(Integer goodsId);

    List<Sku> findByGoodsId(Integer goodsId);

    Integer findGoodsIdBySkuId(Integer skuId);
}
