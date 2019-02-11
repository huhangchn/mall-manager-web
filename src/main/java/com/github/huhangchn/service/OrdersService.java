package com.github.huhangchn.service;
import com.github.huhangchn.dto.OrderDto;
import com.github.huhangchn.dto.OrderInfo;
import com.github.huhangchn.dto.PageOrder;
import com.github.huhangchn.dto.PayInfo;
import com.github.huhangchn.model.Orders;
import com.github.huhangchn.core.Service;


/**
* Created by CodeGenerator on 2019/01/29.
*/
public interface OrdersService extends Service<Orders> {

    PageOrder getOrderList(Long userId, int page, int size);

    OrderDto getOrder(Long orderId);

    Long createOrder(OrderInfo orderInfo);

    int cancelOrder(Long orderId);

    int delOrder(Long orderId);

    int payOrder(PayInfo payInfo);
}
