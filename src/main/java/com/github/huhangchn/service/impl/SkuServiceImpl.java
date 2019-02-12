package com.github.huhangchn.service.impl;

import com.github.huhangchn.dao.SkuMapper;
import com.github.huhangchn.dto.SkuDto;
import com.github.huhangchn.model.Sku;
import com.github.huhangchn.service.SkuService;
import com.github.huhangchn.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
* Created by CodeGenerator on 2019/01/29.
*/
@Service
@Transactional
public class SkuServiceImpl extends AbstractService<Sku> implements SkuService {
    @Autowired
    private SkuMapper skuMapper;

    @Override
    public int deleteByGoodsId(Integer goodsId) {
        return skuMapper.deleteByGoodsId(goodsId);
    }

    @Override
    public List<Sku> findByGoodsId(Integer goodsId) {
        return skuMapper.selectByGoodsId(goodsId);
    }

    @Override
    public Integer findGoodsIdBySkuId(Integer skuId) {
        return skuMapper.selectGoodsIdBySkuId(skuId);
    }

    @Override
    public SkuDto findSkuDtoById(Integer skuId) {
        return skuMapper.selectSkuDtoById(skuId);
    }
}
