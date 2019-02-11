package com.github.huhangchn.dao;

import com.github.huhangchn.core.Mapper;
import com.github.huhangchn.dto.OrdersModel;
import com.github.huhangchn.model.Orders;

import java.util.List;

public interface OrdersMapper extends Mapper<Orders> {
    List<OrdersModel> selectOrdersModelByUserId(Long userId);

    OrdersModel selectOrderModelByOrderId(Long orderId);
}