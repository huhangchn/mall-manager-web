package com.github.huhangchn.service.impl;

import com.github.huhangchn.dao.AttributeMapper;
import com.github.huhangchn.dao.GoodsMapper;
import com.github.huhangchn.dto.*;
import com.github.huhangchn.model.Goods;
import com.github.huhangchn.service.ContentService;
import com.github.huhangchn.service.GoodsAttributeValueService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private AttributeMapper attributeMapper;

    @Autowired
    private GoodsAttributeValueService gavService;

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
        if (goods == null) {
            return null;
        }
        return DtoUtil.Goods2ProductDetail(goods);
    }

    @Override
    public List<AttributeDto> getAttributeList() {
        return attributeMapper.selectBasicOptions();
    }

    @Override
    public AllGoodsResult getBySearchDto(GoodsFrontSearchDto searchDto) {
        Integer page = searchDto.getPage();
        Integer size = searchDto.getSize();
        String sort = searchDto.getSort();
        Long cid = searchDto.getCid();
        Integer priceGt = searchDto.getPriceGt();
        Integer priceLte = searchDto.getPriceLte();
        Integer brandId = searchDto.getBrandId();
        Integer categoryId = searchDto.getCategoryId();
        List<Integer> valueIdsList = searchDto.getValueIds();
        List<Integer> goodsIdList = gavService.findGoodsIdsByAllValueIdList(valueIdsList);
        if(goodsIdList == null || goodsIdList.isEmpty()){
            return new AllGoodsResult();
        }

        Condition condition = new Condition(Goods.class);
        Example.Criteria criteria = condition.createCriteria();
        criteria.andIn("id", goodsIdList);
        if (brandId != null)
            criteria.andEqualTo(brandId);
        if (categoryId != null)
            criteria.andEqualTo(categoryId);

        AllGoodsResult allGoodsResult = new AllGoodsResult();
        List<Product> list = new ArrayList<>();

        PageHelper.startPage(page, size);
        List<Goods> goodsList = goodsMapper.selectByCondition(condition);
        PageInfo<Goods> pageInfo = new PageInfo<>(goodsList);

        for (Goods goods : goodsList) {
            Product product = DtoUtil.Goods2Product(goods);
            list.add(product);
        }

        allGoodsResult.setData(list);
        allGoodsResult.setTotal((int) pageInfo.getTotal());

        return allGoodsResult;
    }

}