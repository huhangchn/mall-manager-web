package com.github.huhangchn.service.impl;

import com.github.huhangchn.core.AbstractService;
import com.github.huhangchn.dao.GoodsMapper;
import com.github.huhangchn.dto.GoodsInfoDto;
import com.github.huhangchn.model.Goods;
import com.github.huhangchn.model.GoodsAttributeValue;
import com.github.huhangchn.model.Sku;
import com.github.huhangchn.service.GoodsAttributeValueService;
import com.github.huhangchn.service.GoodsService;
import com.github.huhangchn.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by CodeGenerator on 2019/01/27.
 */
@Service
@Transactional
public class GoodsServiceImpl extends AbstractService<Goods> implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    GoodsAttributeValueService valueService;

    @Autowired
    SkuService skuService;

    @Override
    public GoodsInfoDto getGoodsInfo(Integer goodsId){
        return goodsMapper.selectGoodsInfo(goodsId);
    }

    @Override
    public int updateGoodsSaleStatus(Integer goodsId, Boolean isOnSale) {
        Goods goods = new Goods();
        goods.setId(goodsId);
        goods.setIsOnSale(isOnSale);
        return updateByPrimaryKeySelective(goods);
    }

    @Override
    public void updateGoods(GoodsInfoDto goodsInfoDto) {
        updateByPrimaryKeySelective(goodsInfoDto);

        //先删除
        Integer goodsId = goodsInfoDto.getId();
        valueService.deleteByGoodsId(goodsId);
        //再添加
        List<GoodsAttributeValue> gavList = getGAV(goodsId, goodsInfoDto);
        valueService.saveSelective(gavList);

        skuService.deleteByGoodsId(goodsId);
        List<Sku> skuList = getSkuList(goodsId, goodsInfoDto);
        skuList.forEach(sku -> skuService.saveSelective(sku));
    }

    @Override
    public void addGoods(GoodsInfoDto goodsInfoDto) {
        Goods goods = getGoods(goodsInfoDto);
        saveSelective(goods);

        Integer goodsId = goods.getId();
        List<GoodsAttributeValue> gavList = getGAV(goodsId, goodsInfoDto);
        valueService.saveSelective(gavList);

        List<Sku> skuList = getSkuList(goodsId, goodsInfoDto);
        skuService.saveSelective(skuList);
    }

    private List<Sku> getSkuList(Integer goodsId, GoodsInfoDto goodsInfoDto) {
        List<Sku> skuList = goodsInfoDto.getSkuList();
        skuList.forEach( sku -> {
            sku.setId(null);
            sku.setGoodsId(goodsId);
            sku.setNumber(UUID.randomUUID().toString());
            sku.setCreateTime(new Date());
        });
        return skuList;
    }

    private List<GoodsAttributeValue> getGAV(Integer goodsId, GoodsInfoDto goodsInfoDto) {
        List<Integer> valueIdList = goodsInfoDto.getBasicValueId();
        List<GoodsAttributeValue> gavList = new ArrayList<>();
        valueIdList.forEach(valueId -> {
            GoodsAttributeValue gav = new GoodsAttributeValue();
            gav.setGoodsId(goodsId);
            gav.setValueId(valueId);
            gavList.add(gav);
        });
        return gavList;
    }

    private Goods getGoods(GoodsInfoDto goodsInfoDto) {
        goodsInfoDto.setNumber(UUID.randomUUID().toString());
        return goodsInfoDto;
    }
}
