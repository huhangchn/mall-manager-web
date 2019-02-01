package com.github.huhangchn.web;

import com.github.huhangchn.result.Result;
import com.github.huhangchn.result.ResultFactory;
import com.github.huhangchn.model.AttributeValue;
import com.github.huhangchn.service.AttributeValueService;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

/**
* Created by CodeGenerator on 2019/01/29.
*/
@RestController
@RequestMapping("/attribute/value")
public class AttributeValueController {
    @Autowired
    private AttributeValueService attributeValueService;

    @PostMapping
    public Result add(@RequestBody AttributeValue attributeValue) {
        return ResultFactory.success(attributeValueService.saveSelective(attributeValue));
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return ResultFactory.success(attributeValueService.deleteById(id));
    }

    @PutMapping
    public Result update(@RequestBody AttributeValue attributeValue) {
        return ResultFactory.success(attributeValueService.updateByPrimaryKeySelective(attributeValue));
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        return ResultFactory.success(attributeValueService.findById(id));
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        return ResultFactory.success(attributeValueService.findAll(page, size));
    }
}
