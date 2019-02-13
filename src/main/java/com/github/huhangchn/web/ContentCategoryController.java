package com.github.huhangchn.web;

import com.github.huhangchn.model.ContentCategory;
import com.github.huhangchn.result.Result;
import com.github.huhangchn.result.ResultFactory;
import com.github.huhangchn.service.ContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
* Created by CodeGenerator on 2019/02/13.
*/
@RestController
@RequestMapping("/content/category")
public class ContentCategoryController {
    @Autowired
    private ContentCategoryService contentCategoryService;

    @PostMapping
    public Result add(@RequestBody ContentCategory contentCategory) {
        return ResultFactory.success(contentCategoryService.saveSelective(contentCategory));
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return ResultFactory.success(contentCategoryService.deleteById(id));
    }

    @PutMapping
    public Result update(@RequestBody ContentCategory contentCategory) {
        return ResultFactory.success(contentCategoryService.updateByPrimaryKeySelective(contentCategory));
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        return ResultFactory.success(contentCategoryService.findById(id));
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        return ResultFactory.success(contentCategoryService.findAll(page, size));
    }
}
