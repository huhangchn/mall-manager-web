package com.github.huhangchn.web;

import com.github.huhangchn.result.Result;
import com.github.huhangchn.result.ResultFactory;
import com.github.huhangchn.model.GoodsAttributeValue;
import com.github.huhangchn.service.GoodsAttributeValueService;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

/**
* Created by CodeGenerator on 2019/02/01.
*/
@RestController
@RequestMapping("/goods/attribute/value")
public class GoodsAttributeValueController {
    @Autowired
    private GoodsAttributeValueService goodsAttributeValueService;

    @PostMapping
    public Result add(@RequestBody GoodsAttributeValue goodsAttributeValue) {
        return ResultFactory.success(goodsAttributeValueService.saveSelective(goodsAttributeValue));
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return ResultFactory.success(goodsAttributeValueService.deleteById(id));
    }

    @PutMapping
    public Result update(@RequestBody GoodsAttributeValue goodsAttributeValue) {
        return ResultFactory.success(goodsAttributeValueService.updateByPrimaryKeySelective(goodsAttributeValue));
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        return ResultFactory.success(goodsAttributeValueService.findById(id));
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        return ResultFactory.success(goodsAttributeValueService.findAll(page, size));
    }
}
