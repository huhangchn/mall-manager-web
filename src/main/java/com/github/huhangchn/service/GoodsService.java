package com.github.huhangchn.service;

import com.github.huhangchn.dto.GoodsInfoDto;
import com.github.huhangchn.model.Goods;
import com.github.huhangchn.core.Service;


/**
 * Created by CodeGenerator on 2019/01/27.
 */
public interface GoodsService extends Service<Goods> {

    void addGoods(GoodsInfoDto goodsInfoDto);

    GoodsInfoDto getGoodsInfo(Integer goodsId);

    int updateGoodsSaleStatus(Integer goodsId, Boolean isOnSale);

    void updateGoods(GoodsInfoDto goodsInfoDto);


}
