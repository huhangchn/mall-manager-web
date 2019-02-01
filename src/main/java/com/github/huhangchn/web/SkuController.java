package com.github.huhangchn.web;

import com.github.huhangchn.model.Sku;
import com.github.huhangchn.result.Result;
import com.github.huhangchn.result.ResultFactory;
import com.github.huhangchn.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
* Created by CodeGenerator on 2019/01/29.
*/
@RestController
@RequestMapping("/sku")
public class SkuController {
    @Autowired
    private SkuService skuService;

    @PostMapping
    public Result add(@RequestBody Sku sku) {
        return ResultFactory.success(skuService.saveSelective(sku));
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return ResultFactory.success(skuService.deleteById(id));
    }

    @PutMapping
    public Result update(@RequestBody Sku sku) {
        return ResultFactory.success(skuService.updateByPrimaryKeySelective(sku));
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        return ResultFactory.success(skuService.findById(id));
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        return ResultFactory.success(skuService.findAll(page, size));
    }
}
