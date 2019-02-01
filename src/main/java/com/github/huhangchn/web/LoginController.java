package com.github.huhangchn.web;

import com.github.huhangchn.model.User;
import com.github.huhangchn.result.CodeMsg;
import com.github.huhangchn.result.Result;
import com.github.huhangchn.result.ResultFactory;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class LoginController {
    @PostMapping("/login/login")
    public Result adminLogin(@RequestBody User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password)){
            return ResultFactory.error(CodeMsg.LOGIN_ERROR);
        }
        String token = username + System.currentTimeMillis();
        Map<String,Object> map = new HashMap<>();
        map.put("token", token);
        return ResultFactory.success(map);
    }




    @GetMapping(value = "/user/info")
    public Result info(@RequestParam String token){
        Map<String, Object> map = new HashMap<>();
        map.put("roles", Arrays.asList("admin","editor"));
        map.put("token", token);
        map.put("introduction", "超级管理员");
        map.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        map.put("name", "胡杭");
        return ResultFactory.success(map);
    }

    @PostMapping(value = "/login/logout")
    public Result info(){
        // TODO 登出
        return ResultFactory.success();
    }
}
