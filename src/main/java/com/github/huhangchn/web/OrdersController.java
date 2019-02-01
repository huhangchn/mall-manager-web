package com.github.huhangchn.web;

import com.github.huhangchn.result.Result;
import com.github.huhangchn.result.ResultFactory;
import com.github.huhangchn.model.Orders;
import com.github.huhangchn.service.OrdersService;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

/**
* Created by CodeGenerator on 2019/01/29.
*/
@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    @PostMapping
    public Result add(@RequestBody Orders orders) {
        return ResultFactory.success(ordersService.saveSelective(orders));
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return ResultFactory.success(ordersService.deleteById(id));
    }

    @PutMapping
    public Result update(@RequestBody Orders orders) {
        return ResultFactory.success(ordersService.updateByPrimaryKeySelective(orders));
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        return ResultFactory.success(ordersService.findById(id));
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        return ResultFactory.success(ordersService.findAll(page, size));
    }
}
