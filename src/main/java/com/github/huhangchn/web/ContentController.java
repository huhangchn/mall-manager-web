package com.github.huhangchn.web;

import com.github.huhangchn.model.Content;
import com.github.huhangchn.result.Result;
import com.github.huhangchn.result.ResultFactory;
import com.github.huhangchn.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
* Created by CodeGenerator on 2019/02/13.
*/
@RestController
@RequestMapping("/content")
public class ContentController {
    @Autowired
    private ContentService contentService;

    @PostMapping
    public Result add(@RequestBody Content content) {
        return ResultFactory.success(contentService.saveSelective(content));
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return ResultFactory.success(contentService.deleteById(id));
    }

    @PutMapping
    public Result update(@RequestBody Content content) {
        return ResultFactory.success(contentService.updateByPrimaryKeySelective(content));
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        return ResultFactory.success(contentService.findById(id));
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        return ResultFactory.success(contentService.findAll(page, size));
    }
}
