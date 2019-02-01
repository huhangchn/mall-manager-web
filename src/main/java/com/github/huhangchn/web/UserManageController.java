package com.github.huhangchn.web;

import com.github.huhangchn.model.User;
import com.github.huhangchn.result.Result;
import com.github.huhangchn.result.ResultFactory;
import com.github.huhangchn.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/user")
public class UserManageController {
    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public Result list(String username, String mobile,
                       @RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer limit) {
        User user = new User().setUsername(username).setMobile(mobile);
        PageInfo<User> userPageInfo = userService.findAll(user, page, limit);
        List<User> userList = userPageInfo.getList();
        long total = userPageInfo.getTotal();
        Map<String, Object> data = new HashMap<>();
        data.put("total", total);
        data.put("items", userList);
        return ResultFactory.success(data);
    }
}
