package com.github.huhangchn.web;

import com.github.huhangchn.model.User;
import com.github.huhangchn.result.Result;
import com.github.huhangchn.result.ResultFactory;
import com.github.huhangchn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by huhang on 2019/01/26.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public Result add(@RequestBody User user) {
        return ResultFactory.success(userService.saveSelective(user));
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return ResultFactory.success(userService.deleteById(id));
    }

    @PutMapping
    public Result update(@RequestBody User user) {
        return ResultFactory.success(userService.updateByPrimaryKeySelective(user));
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        return ResultFactory.success(userService.findById(id));
    }



}
