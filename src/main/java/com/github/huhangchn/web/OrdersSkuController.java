package com.github.huhangchn.web;

import com.github.huhangchn.result.Result;
import com.github.huhangchn.result.ResultFactory;
import com.github.huhangchn.model.OrdersSku;
import com.github.huhangchn.service.OrdersSkuService;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

/**
* Created by CodeGenerator on 2019/01/29.
*/
@RestController
@RequestMapping("/orders/sku")
public class OrdersSkuController {
    @Autowired
    private OrdersSkuService ordersSkuService;

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
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        return ResultFactory.success(ordersSkuService.findAll(page, size));
    }
}
