package com.github.huhangchn.dto;

import com.github.huhangchn.model.Goods;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

public class DtoUtil {
    public static Product Goods2Product(Goods goods) {
        Product product = new Product();
        product.setProductId(goods.getId());
        product.setProductName(goods.getName());
        product.setSubTitle(goods.getBrief());
        product.setSalePrice(goods.getPrice());
        product.setProductImageBig(goods.getPicUrl());
        return product;
    }

    public static ProductDetail Goods2ProductDetail(Goods goods) {
        ProductDetail productDetail = new ProductDetail();
        productDetail.setProductId(goods.getId());
        productDetail.setProductName(goods.getName());
        productDetail.setSubTitle(goods.getBrief());
        productDetail.setDetail(goods.getDetail());
        productDetail.setSalePrice(goods.getPrice());
        productDetail.setProductImageBig(goods.getPicUrl());
        String gallery = goods.getGallery();
        if(StringUtils.isNotEmpty(gallery)){
            productDetail.setProductImageSmall(Arrays.asList(gallery.split(",")));
        }
        return productDetail;
    }
}
