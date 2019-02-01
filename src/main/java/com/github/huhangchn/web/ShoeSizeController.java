package com.github.huhangchn.web;

import com.github.huhangchn.model.ShoeSize;
import com.github.huhangchn.result.Result;
import com.github.huhangchn.result.ResultFactory;
import com.github.huhangchn.service.ShoeSizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
* Created by CodeGenerator on 2019/01/31.
*/
@RestController
@RequestMapping("/shoeSize")
public class ShoeSizeController {
    @Autowired
    private ShoeSizeService shoeSizeService;

    @PostMapping
    public Result add(@RequestBody ShoeSize shoeSize) {
        return ResultFactory.success(shoeSizeService.saveSelective(shoeSize));
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return ResultFactory.success(shoeSizeService.deleteById(id));
    }

    @PutMapping
    public Result update(@RequestBody ShoeSize shoeSize) {
        return ResultFactory.success(shoeSizeService.updateByPrimaryKeySelective(shoeSize));
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        return ResultFactory.success(shoeSizeService.findById(id));
    }

    @GetMapping
    public Result list() {
        return ResultFactory.success(shoeSizeService.findAll());
    }
}
