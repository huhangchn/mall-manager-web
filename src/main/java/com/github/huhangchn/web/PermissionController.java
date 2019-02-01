package com.github.huhangchn.web;

import com.github.huhangchn.result.Result;
import com.github.huhangchn.result.ResultFactory;
import com.github.huhangchn.model.Permission;
import com.github.huhangchn.service.PermissionService;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by CodeGenerator on 2019/01/27.
 */
@RestController
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    @PostMapping
    public Result add(@RequestBody Permission permission) {
        return ResultFactory.success(permissionService.saveSelective(permission));
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return ResultFactory.success(permissionService.deleteById(id));
    }

    @PutMapping
    public Result update(@RequestBody Permission permission) {
        return ResultFactory.success(permissionService.updateByPrimaryKeySelective(permission));
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        return ResultFactory.success(permissionService.findById(id));
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        return ResultFactory.success(permissionService.findAll(page, size));
    }
}
