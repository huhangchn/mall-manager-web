package com.github.huhangchn.web;

import com.github.huhangchn.model.Category;
import com.github.huhangchn.result.Result;
import com.github.huhangchn.result.ResultFactory;
import com.github.huhangchn.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by huhang on 2019/01/26.
 */
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public Result add(@RequestBody Category category) {
        return ResultFactory.success(categoryService.saveSelective(category));
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return ResultFactory.success(categoryService.deleteById(id));
    }

    @PutMapping
    public Result update(@RequestBody Category category) {
        return ResultFactory.success(categoryService.updateByPrimaryKeySelective(category));
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        return ResultFactory.success(categoryService.findById(id));
    }

    @GetMapping("/listPage")
    public Result list(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer limit) {
        return ResultFactory.success(categoryService.findAll(page, limit));
    }

    @GetMapping
    public Result list() {
        return ResultFactory.success(categoryService.findAll());
    }

    /**
     * 暂时用不到
     */
    @GetMapping(value = "/tree")
    public Result getTree() {
        return ResultFactory.success(categoryService.getTree());
    }

}
