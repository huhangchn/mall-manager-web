package com.github.huhangchn.service.impl;

import com.github.huhangchn.core.AbstractService;
import com.github.huhangchn.dao.OrdersMapper;
import com.github.huhangchn.dto.*;
import com.github.huhangchn.model.Orders;
import com.github.huhangchn.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
        return null;
    }

    @Override
    public int cancelOrder(Long orderId) {
        return 0;
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
