package com.github.huhangchn.web;

import com.github.huhangchn.result.Result;
import com.github.huhangchn.result.ResultFactory;
import com.github.huhangchn.model.Goods;
import com.github.huhangchn.service.GoodsService;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by CodeGenerator on 2019/01/27.
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @PostMapping
    public Result add(@RequestBody Goods goods) {
        return ResultFactory.success(goodsService.saveSelective(goods));
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return ResultFactory.success(goodsService.deleteById(id));
    }

    @PutMapping
    public Result update(@RequestBody Goods goods) {
        return ResultFactory.success(goodsService.updateByPrimaryKeySelective(goods));
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        return ResultFactory.success(goodsService.findById(id));
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        return ResultFactory.success(goodsService.findAll(page, size));
    }
}
