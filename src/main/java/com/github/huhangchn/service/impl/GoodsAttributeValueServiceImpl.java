package com.github.huhangchn.service.impl;

import com.github.huhangchn.dao.GoodsAttributeValueMapper;
import com.github.huhangchn.model.GoodsAttributeValue;
import com.github.huhangchn.service.GoodsAttributeValueService;
import com.github.huhangchn.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

/**
* Created by CodeGenerator on 2019/02/01.
*/
@Service
@Transactional
public class GoodsAttributeValueServiceImpl extends AbstractService<GoodsAttributeValue> implements GoodsAttributeValueService {
    @Autowired
    private GoodsAttributeValueMapper valueMapper;

    @Override
    public int deleteByGoodsId(Integer goodsId) {
        return valueMapper.deleteByGoodsId(goodsId);
    }
}
