package com.github.huhangchn.front.controller;

import com.github.huhangchn.result.Result;
import com.github.huhangchn.result.ResultFactory;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description = "商城首页")
public class MallHomeController {


    @GetMapping("/home")
    @ApiOperation(value = "获取首页内容")
    public Result home(){
        return ResultFactory.success();
    }
}
