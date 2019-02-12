package com.github.huhangchn.service;
import com.github.huhangchn.dto.CartDto;
import com.github.huhangchn.model.Cart;
import com.github.huhangchn.core.Service;

import java.util.List;


/**
* Created by CodeGenerator on 2019/02/09.
*/
public interface CartService extends Service<Cart> {

    /**
     * 获取指定用户的购物车信息
     */
    List<CartDto> getCartList(Integer userId);

    /**
     * 更新购物车选中状态
     */
    int updateByUserIdAndSkuId(Integer userId, Integer skuId, Integer num, String checked);

    /**
     * 购物车全选与全不选
     */
    int checkAll(Integer userId, String checked);

    /**
     * 删除购物车条目
     */
    int deleteCartItem(Integer userId, Integer skuId);

    /**
     * 删除购物车选中条目
     */
    int delChecked(Integer userId);

    /**
     * 购物车计数
     */
    int countByUserIdAndSkuId(Integer userId, Integer skuId);

    /**
     * 增加购物车条目商品的数量
     */
    int addNumByUserIdAndSkuId(Integer userId, Integer skuId, Integer num);

    /**
     * 找出选中的购物车条目
     */
    List<Cart> findChecked(Integer userId);
}
