package com.github.huhangchn.web;

import com.github.huhangchn.model.Brand;
import com.github.huhangchn.result.Result;
import com.github.huhangchn.result.ResultFactory;
import com.github.huhangchn.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by CodeGenerator on 2019/01/27.
 */
@RestController
@RequestMapping("/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

    @PostMapping
    public Result add(@RequestBody Brand brand) {
        return ResultFactory.success(brandService.saveSelective(brand));
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return ResultFactory.success(brandService.deleteById(id));
    }

    @PutMapping
    public Result update(@RequestBody Brand brand) {
        return ResultFactory.success(brandService.updateByPrimaryKeySelective(brand));
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        return ResultFactory.success(brandService.findById(id));
    }


    @GetMapping
    public Result listAll() {
        return ResultFactory.success(brandService.findAll());
    }

    @GetMapping("/listPage")
    public Result listAll(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer limit) {
        return ResultFactory.success(brandService.findAll(page, limit));
    }

    /**
     *  获取品牌列表，暂时用不到
     */
    @GetMapping("/list")
    public Result list(@RequestParam(required = false) Integer categoryId){
        return ResultFactory.success(brandService.findByCategory(categoryId));
    }
}
