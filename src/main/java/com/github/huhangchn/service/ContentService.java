package com.github.huhangchn.service;

import com.github.huhangchn.dto.AllGoodsResult;
import com.github.huhangchn.dto.ProductDetail;

public interface ContentService {
    AllGoodsResult getAllProduct(int page, int size, String sort, Long cid, int priceGt, int priceLte);

    ProductDetail getProductDetail(int goodsId);
}
