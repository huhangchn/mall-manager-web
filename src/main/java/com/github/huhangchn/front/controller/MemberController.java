package com.github.huhangchn.front.controller;

import com.github.huhangchn.dto.Member;
import com.github.huhangchn.dto.MemberLoginRegist;
import com.github.huhangchn.result.Result;
import com.github.huhangchn.result.ResultFactory;
import com.github.huhangchn.service.LoginService;
import com.github.huhangchn.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Exrickx
 */
@RestController
@Api(description = "会员注册登录")
public class MemberController {

    private final static Logger log= LoggerFactory.getLogger(MemberController.class);

    @Autowired
    private LoginService loginService;
//    @Autowired
//    private MemberService memberService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/member/login",method = RequestMethod.POST)
    @ApiOperation(value = "用户登录")
    public Result login(@RequestBody MemberLoginRegist memberLoginRegist,
                                HttpServletRequest request){
        Member member = loginService.login(memberLoginRegist);
        return ResultFactory.success(member);
    }

    @RequestMapping(value = "/member/checkLogin",method = RequestMethod.GET)
    @ApiOperation(value = "判断用户是否登录")
    public Result checkLogin(@RequestParam(defaultValue = "") String token){

        Member member=loginService.getUserByToken(token);
        return  ResultFactory.success(member);
    }

    @RequestMapping(value = "/member/loginOut",method = RequestMethod.GET)
    @ApiOperation(value = "退出登录")
    public Result logout(@RequestParam(defaultValue = "") String token){

        loginService.logout(token);
        return ResultFactory.success();
    }

//    @RequestMapping(value = "/member/register",method = RequestMethod.POST)
//    @ApiOperation(value = "用户注册")
//    public Result register(@RequestBody MemberLoginRegist memberLoginRegist,
//                                   HttpServletRequest request){
//        userService.register(memberLoginRegist);
//        return ResultFactory.success();
//    }

//    @RequestMapping(value = "/member/imgaeUpload",method = RequestMethod.POST)
//    @ApiOperation(value = "用户头像上传")
//    public Result imgaeUpload(@RequestBody CommonDto common){
//
//        String imgPath = memberService.imageUpload(common.getUserId().longValue(),common.getToken(),common.getImgData());
//        return ResultFactory.success(imgPath);
//    }
}