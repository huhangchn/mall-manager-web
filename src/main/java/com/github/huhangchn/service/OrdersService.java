package com.github.huhangchn.service;
import com.github.huhangchn.core.Service;
import com.github.huhangchn.dto.OrderDto;
import com.github.huhangchn.dto.OrderInfo;
import com.github.huhangchn.dto.PageOrder;
import com.github.huhangchn.model.Orders;


/**
* Created by CodeGenerator on 2019/01/29.
*/
public interface OrdersService extends Service<Orders> {

    PageOrder getOrderList(Long userId, int page, int size);

    PageOrder getOrderList(int page, int size, Integer orderId, String username, String orderStatus);

    OrderDto getOrder(Long orderId);

    Long createOrder(OrderInfo orderInfo);

    int cancelOrder(Long orderId);

    int delOrder(Long orderId);

    int payOrder(Long orderId);

    int sendOrder(Long orderId);

    int confirmOrder(Long orderId);
}
