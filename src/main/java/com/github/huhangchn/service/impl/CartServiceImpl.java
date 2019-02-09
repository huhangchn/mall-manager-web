package com.github.huhangchn.service.impl;

import com.github.huhangchn.core.AbstractService;
import com.github.huhangchn.dao.CartMapper;
import com.github.huhangchn.dto.CartDto;
import com.github.huhangchn.model.Cart;
import com.github.huhangchn.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* Created by CodeGenerator on 2019/02/09.
*/
@Service
@Transactional
public class CartServiceImpl extends AbstractService<Cart> implements CartService {
    @Autowired
    private CartMapper cartMapper;

    @Override
    public List<CartDto> getCartList(Integer userId) {
        return cartMapper.selectCartList(userId);
    }

    @Override
    public int updateByUserIdAndSkuId(Integer userId, Integer skuId, Integer num, String checked) {
        return cartMapper.updateByUserIdAndSkuId(userId, skuId, num, checked);
    }

    @Override
    public int checkAll(Integer userId, String checked) {
        return cartMapper.updateCheckedByUserId(userId, checked);
    }

    @Override
    public int deleteCartItem(Integer userId, Integer skuId) {
        return cartMapper.deleteByUserIdAndSkuId(userId, skuId);
    }

    @Override
    public int delChecked(Integer userId) {
        return cartMapper.deleteCheckedByUserId(userId);
    }

    @Override
    public int countByUserIdAndSkuId(Integer userId, Integer skuId) {
        return cartMapper.countByUserIdAndSkuId(userId, skuId);
    }

    @Override
    public int addNumByUserIdAndSkuId(Integer userId, Integer skuId, Integer num) {
        return cartMapper.addNumByUserIdAndSkuId(userId, skuId, num);
    }
}
