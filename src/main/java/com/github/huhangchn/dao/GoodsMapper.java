package com.github.huhangchn.dao;

import com.github.huhangchn.core.Mapper;
import com.github.huhangchn.dto.GoodsInfoDto;
import com.github.huhangchn.dto.GoodsValuesDto;
import com.github.huhangchn.model.Goods;

import java.util.List;

public interface GoodsMapper extends Mapper<Goods> {
    GoodsInfoDto selectGoodsInfo(Integer goodsId);


    List<Goods> selectGoods(Long cid, String orderCol, String orderDir, int priceGt, int priceLte);

    List<GoodsValuesDto> selectBySearchDto(Integer brandId, Integer categoryId, Long cid, String orderCol, String orderDir, Integer priceGt, Integer priceLte);
}