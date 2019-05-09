package com.github.huhangchn.dao;

import com.github.huhangchn.core.Mapper;
import com.github.huhangchn.dto.OrdersModel;
import com.github.huhangchn.model.Orders;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface OrdersMapper extends Mapper<Orders> {
    List<OrdersModel> selectOrdersModelByUserId(Long userId);

    OrdersModel selectOrderModelByOrderId(Long orderId);

    @Update("update orders set status = '6' where id = #{orderId}")
    int cancelOrder(Long orderId);

    @Update("update orders set deleted = '1' where id = #{orderId}")
    int deleteLogically(Long orderId);

    List<OrdersModel> selectOrdersModel(@Param("orderId") Integer orderId, @Param("username") String username, @Param("orderStatus") String orderStatus);

    @Update("update orders set status = '1' where id = #{orderId}")
    int payOrder(Long orderId);

    @Update("update orders set status = '2' where id = #{orderId}")
    int sendOrder(Long orderId);

    @Update("update orders set status = '3' where id = #{orderId}")
    int confirmOrder(Long orderId);
}