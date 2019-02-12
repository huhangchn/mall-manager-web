package com.github.huhangchn.front.controller;

import com.github.huhangchn.dto.OrderDto;
import com.github.huhangchn.dto.OrderInfo;
import com.github.huhangchn.dto.PageOrder;
import com.github.huhangchn.dto.PayInfo;
import com.github.huhangchn.result.Result;
import com.github.huhangchn.result.ResultFactory;
import com.github.huhangchn.service.OrdersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@Api(description = "订单")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @RequestMapping(value = "/orders/orderList",method = RequestMethod.GET)
    @ApiOperation(value = "获得用户所有订单")
    public Result getOrderList(String userId,
                                          @RequestParam(defaultValue = "1") int page,
                                          @RequestParam(defaultValue = "5") int size){

        PageOrder pageOrder= ordersService.getOrderList(Long.valueOf(userId), page, size);
        return ResultFactory.success(pageOrder);
    }

    @RequestMapping(value = "/orders/orderDetail",method = RequestMethod.GET)
    @ApiOperation(value = "通过id获取订单")
    public Result getOrder(String orderId){
        OrderDto order= ordersService.getOrder(Long.valueOf(orderId));
        return ResultFactory.success(order);
    }

    @RequestMapping(value = "/orders/addOrder",method = RequestMethod.POST)
    @ApiOperation(value = "创建订单")
    public Result addOrder(@RequestBody OrderInfo orderInfo){

        Long orderId= ordersService.createOrder(orderInfo);
        return ResultFactory.success(orderId.toString());
    }

    @RequestMapping(value = "/orders/cancelOrder",method = RequestMethod.POST)
    @ApiOperation(value = "取消订单")
    public Result cancelOrder(@RequestBody OrderDto order){
        int result= ordersService.cancelOrder(order.getOrderId());
        return ResultFactory.success(result);
    }

    @RequestMapping(value = "/orders/delOrder",method = RequestMethod.GET)
    @ApiOperation(value = "删除订单")
    public Result delOrder(String orderId){

        int result= ordersService.delOrder(Long.valueOf(orderId));
        return ResultFactory.success(result);
    }

    @RequestMapping(value = "/orders/payOrder",method = RequestMethod.POST)
    @ApiOperation(value = "支付订单")
    public Result payOrder(@RequestBody PayInfo payInfo){

        int result= ordersService.payOrder(payInfo);
        return ResultFactory.success(result);
    }

}
