package com.github.huhangchn.service;

import com.github.huhangchn.dto.*;

import java.util.List;

public interface ContentService {
    AllGoodsResult getAllProduct(int page, int size, String sort, Long cid, int priceGt, int priceLte);

    ProductDetail getProductDetail(int goodsId);

    List<AttributeDto> getAttributeList();

    AllGoodsResult getBySearchDto(GoodsFrontSearchDto searchDto);
}
