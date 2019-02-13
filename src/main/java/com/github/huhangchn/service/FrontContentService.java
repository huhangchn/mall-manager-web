package com.github.huhangchn.service;

import com.github.huhangchn.dto.*;
import com.github.huhangchn.model.Sku;

import java.util.List;

public interface FrontContentService {
    /**
     * 获取所有的商品
     */
    AllGoodsResult getAllProduct(int page, int size, String sort, Long cid, int priceGt, int priceLte);

    /**
     * 商品详情
     */
    ProductDetail getProductDetail(int goodsId);

    /**
     * 属性列表
     */
    List<AttributeDto> getAttributeList();

    /**
     * 根据SearchDto进行商品筛选
     */
    AllGoodsResult getBySearchDto(GoodsFrontSearchDto searchDto);

    /**
     * 根据商品id获取销售属性
     */
    List<Sku> getProductSaleInfo(Integer productId);

    /**
     * 通过关键字查找
     */
    AllGoodsResult findByKey(String key, int page, int size);

    /**
     * 商品详情根据skuId
     */
    ProductDetail getProductDetailBySkuId(Integer skuId);

    /**
     * 根据skuid获取商品id
     */
    Integer getGoodsIdBySkuId(Integer skuId);

    /**
     * 获取首页的内容
     */
    List<HomeContent> getHomeContent();
}
