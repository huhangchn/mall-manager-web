package com.github.huhangchn.web;

import com.github.huhangchn.dto.PageOrder;
import com.github.huhangchn.model.OrdersSku;
import com.github.huhangchn.result.Result;
import com.github.huhangchn.result.ResultFactory;
import com.github.huhangchn.service.OrdersService;
import com.github.huhangchn.service.OrdersSkuService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
* Created by CodeGenerator on 2019/01/29.
*/
@RestController
@RequestMapping("admin/order")
public class OrdersManagerController {
    @Autowired
    private OrdersSkuService ordersSkuService;
    @Autowired
    private OrdersService ordersService;

    @PostMapping
    public Result add(@RequestBody OrdersSku ordersSku) {
        return ResultFactory.success(ordersSkuService.saveSelective(ordersSku));
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return ResultFactory.success(ordersSkuService.deleteById(id));
    }

    @PutMapping
    public Result update(@RequestBody OrdersSku ordersSku) {
        return ResultFactory.success(ordersSkuService.updateByPrimaryKeySelective(ordersSku));
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        return ResultFactory.success(ordersSkuService.findById(id));
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "5") Integer size,
                       @RequestParam(required = false) Integer orderId,
                       @RequestParam(required = false) String username,
                       @RequestParam(required = false) String orderStatus
    ) {
        PageOrder pageOrder= ordersService.getOrderList(page, size, orderId, username, orderStatus);
        return ResultFactory.success(pageOrder);
    }

    @RequestMapping(value = "/sendOrder",method = RequestMethod.GET)
    @ApiOperation(value = "发货")
    public Result sendOrder(@RequestParam String orderId){

        int result= ordersService.sendOrder(Long.valueOf(orderId));
        return ResultFactory.success(result);
    }
}
