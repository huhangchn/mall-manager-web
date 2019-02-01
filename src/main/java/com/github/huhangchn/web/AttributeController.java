package com.github.huhangchn.web;

import com.github.huhangchn.model.Attribute;
import com.github.huhangchn.result.Result;
import com.github.huhangchn.result.ResultFactory;
import com.github.huhangchn.service.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
* Created by CodeGenerator on 2019/01/29.
*/
@RestController
@RequestMapping("/attribute")
public class AttributeController {
    @Autowired
    private AttributeService attributeService;

    @PostMapping
    public Result add(@RequestBody Attribute attribute) {
        return ResultFactory.success(attributeService.saveSelective(attribute));
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return ResultFactory.success(attributeService.deleteById(id));
    }

    @PutMapping
    public Result update(@RequestBody Attribute attribute) {
        return ResultFactory.success(attributeService.updateByPrimaryKeySelective(attribute));
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        return ResultFactory.success(attributeService.findById(id));
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        return ResultFactory.success(attributeService.findAll(page, size));
    }

    /**
     *  根据分类id查找对应的商品基本属性
     */
    @GetMapping("/basicOptions")
    public Result basicOptions(){
        return ResultFactory.success(attributeService.findBasicOptions());
    }
}
