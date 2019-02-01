package com.github.huhangchn.service.impl;

import com.github.huhangchn.dao.GoodsMapper;
import com.github.huhangchn.dto.AllGoodsResult;
import com.github.huhangchn.dto.DtoUtil;
import com.github.huhangchn.dto.Product;
import com.github.huhangchn.dto.ProductDetail;
import com.github.huhangchn.model.Goods;
import com.github.huhangchn.service.ContentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public AllGoodsResult getAllProduct(int page, int size, String sort, Long cid, int priceGt, int priceLte) {

        AllGoodsResult allGoodsResult = new AllGoodsResult();
        List<Product> list = new ArrayList<>();

        PageHelper.startPage(page, size);

        //判断条件
        String orderCol = "id";
        String orderDir = "desc";
        if (sort.equals("1")) {
            orderCol = "price";
            orderDir = "asc";
        } else if (sort.equals("-1")) {
            orderCol = "price";
            orderDir = "desc";
        }

        List<Goods> goodsList = goodsMapper.selectGoods(cid, orderCol, orderDir, priceGt, priceLte);
        for (Goods goods : goodsList) {
            Product product = DtoUtil.Goods2Product(goods);
            list.add(product);
        }
        PageInfo<Goods> pageInfo = new PageInfo<>(goodsList);
        allGoodsResult.setData(list);
        allGoodsResult.setTotal((int) pageInfo.getTotal());

        return allGoodsResult;
    }

    @Override
    public ProductDetail getProductDetail(int goodsId) {
        Goods goods = goodsMapper.selectByPrimaryKey(goodsId);
        if(goods == null){
            return null;
        }
        return DtoUtil.Goods2ProductDetail(goods);
    }
}
