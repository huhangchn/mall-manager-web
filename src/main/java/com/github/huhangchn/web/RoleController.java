package com.github.huhangchn.web;

import com.github.huhangchn.result.Result;
import com.github.huhangchn.result.ResultFactory;
import com.github.huhangchn.model.Role;
import com.github.huhangchn.service.RoleService;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by CodeGenerator on 2019/01/27.
 */
@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping
    public Result add(@RequestBody Role role) {
        return ResultFactory.success(roleService.saveSelective(role));
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return ResultFactory.success(roleService.deleteById(id));
    }

    @PutMapping
    public Result update(@RequestBody Role role) {
        return ResultFactory.success(roleService.updateByPrimaryKeySelective(role));
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        return ResultFactory.success(roleService.findById(id));
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        return ResultFactory.success(roleService.findAll(page, size));
    }
}
