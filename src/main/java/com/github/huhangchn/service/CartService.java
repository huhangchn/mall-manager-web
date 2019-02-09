package com.github.huhangchn.service;
import com.github.huhangchn.dto.CartDto;
import com.github.huhangchn.model.Cart;
import com.github.huhangchn.core.Service;

import java.util.List;


/**
* Created by CodeGenerator on 2019/02/09.
*/
public interface CartService extends Service<Cart> {

    List<CartDto> getCartList(Integer userId);

    int updateByUserIdAndSkuId(Integer userId, Integer skuId, Integer num, String checked);

    int checkAll(Integer userId, String checked);

    int deleteCartItem(Integer userId, Integer skuId);

    int delChecked(Integer userId);

    int countByUserIdAndSkuId(Integer userId, Integer skuId);

    int addNumByUserIdAndSkuId(Integer userId, Integer skuId, Integer num);
}
