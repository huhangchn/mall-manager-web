package com.github.huhangchn.front.controller;

import com.github.huhangchn.result.Result;
import com.github.huhangchn.result.ResultFactory;
import com.github.huhangchn.service.FrontContentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description = "商城首页")
@RequestMapping("/home")
public class MallHomeController {

    @Autowired
    FrontContentService frontContentService;

    @GetMapping("/content")
    @ApiOperation(value = "获取首页内容")
    public Result home(){
        return ResultFactory.success(frontContentService.getHomeContent());
    }
}
