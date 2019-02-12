package com.github.huhangchn.service.impl;

import com.github.huhangchn.core.AbstractService;
import com.github.huhangchn.dao.OrdersMapper;
import com.github.huhangchn.dao.OrdersSkuMapper;
import com.github.huhangchn.dto.*;
import com.github.huhangchn.model.*;
import com.github.huhangchn.service.CartService;
import com.github.huhangchn.service.OrdersService;
import com.github.huhangchn.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
* Created by CodeGenerator on 2019/01/29.
*/
@Service
@Transactional
public class OrdersServiceImpl extends AbstractService<Orders> implements OrdersService {
    @Autowired
    private OrdersMapper ordersMapper;

    @Autowired
    private OrdersSkuMapper ordersSkuMapper;

    @Autowired
    private SkuService skuService;
    @Autowired
    private CartService cartService;
    @Override
    public PageOrder getOrderList(Long userId, int page, int size) {
        List<OrdersModel> ordersModelList = ordersMapper.selectOrdersModelByUserId(userId);

        List<OrderDto> orderDtoList = ordersModelList2OrderDtoList(ordersModelList);

        PageOrder pageOrder = new PageOrder();
        pageOrder.setTotal(orderDtoList.size());
        pageOrder.setData(orderDtoList.stream().skip((page - 1) * size).limit(size).collect(Collectors.toList()));
        return pageOrder;
    }

    private List<OrderDto> ordersModelList2OrderDtoList(List<OrdersModel> ordersModelList) {
        List<OrderDto> orderDtoList = new ArrayList<>();
        for (OrdersModel ordersModel : ordersModelList) {
            OrderDto orderDto = DtoUtil.ordersModel2OrderDto(ordersModel);
            orderDtoList.add(orderDto);
        }
        return orderDtoList;
    }

    @Override
    public OrderDto getOrder(Long orderId) {
        OrdersModel ordersModel = ordersMapper.selectOrderModelByOrderId(orderId);
        OrderDto orderDto = DtoUtil.ordersModel2OrderDto(ordersModel);
        return orderDto;
    }

    @Override
    public Long createOrder(OrderInfo orderInfo) {
        Integer userId = Integer.valueOf(orderInfo.getUserId());
        List<Cart> cartList = cartService.findChecked(userId);
        Orders orders = getOrders(orderInfo, cartList);
        ordersMapper.insertSelective(orders);
        List<OrdersSku> ordersSkuList = getOrdersSkuList(orderInfo, cartList, orders.getId());
        ordersSkuMapper.insertList(ordersSkuList);

        //从购物车删除
        cartService.delChecked(userId);
        return Long.valueOf(orders.getId());
    }

    private Orders getOrders(OrderInfo orderInfo, List<Cart> cartList) {
        Orders orders = new Orders();
        orders.setStatus("0");
        orders.setUserId(Integer.valueOf(orderInfo.getUserId()));
        orders.setName(orderInfo.getUserName());
        orders.setMobile(orderInfo.getTel());
        orders.setAddress(orderInfo.getStreetName());
        orders.setTotalPrice(orderInfo.getOrderTotal());
        orders.setOrderPrice(orderInfo.getOrderTotal());
        orders.setActualPay(orderInfo.getOrderTotal());
        orders.setCreateTime(new Date());
        return orders;
    }

    private List<OrdersSku> getOrdersSkuList(OrderInfo orderInfo, List<Cart> cartList, Integer ordersId) {
        List<OrdersSku> ordersSkuList = new ArrayList<>();
        for (Cart cart : cartList) {
            SkuDto skuDto = skuService.findSkuDtoById(cart.getSkuId());
            Goods goods = skuDto.getGoods();
            OrdersSku ordersSku = new OrdersSku();
            ordersSku.setOrdersId(ordersId);
            ordersSku.setSkuId(skuDto.getId());
            ordersSku.setSkuName(goods.getName());
            ordersSku.setSkuImage(goods.getPicUrl());
            ordersSku.setSkuPrice(goods.getPrice());
            ordersSku.setPurchaseNum(cart.getNum());
            ordersSku.setActualPrice(goods.getPrice().multiply(new BigDecimal(cart.getNum())));
            ordersSkuList.add(ordersSku);
        }
        return ordersSkuList;
    }

    @Override
    public int cancelOrder(Long orderId) {
        return ordersMapper.cancelOrder(orderId);
    }

    @Override
    public int delOrder(Long orderId) {
        return 0;
    }

    @Override
    public int payOrder(PayInfo payInfo) {
        return 0;
    }
}
