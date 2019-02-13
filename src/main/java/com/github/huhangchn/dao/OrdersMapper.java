package com.github.huhangchn.dao;

import com.github.huhangchn.core.Mapper;
import com.github.huhangchn.dto.OrdersModel;
import com.github.huhangchn.model.Orders;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface OrdersMapper extends Mapper<Orders> {
    List<OrdersModel> selectOrdersModelByUserId(Long userId);

    OrdersModel selectOrderModelByOrderId(Long orderId);

    @Update("update orders set status = '7' where id = #{orderId}")
    int cancelOrder(Long orderId);

    @Update("update orders set deleted = '1' where id = #{orderId}")
    int deleteLogically(Long orderId);
}