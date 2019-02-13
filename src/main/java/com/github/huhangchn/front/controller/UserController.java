package com.github.huhangchn.front.controller;

import com.github.huhangchn.dto.CommonDto;
import com.github.huhangchn.dto.Member;
import com.github.huhangchn.dto.MemberLoginRegist;
import com.github.huhangchn.model.User;
import com.github.huhangchn.result.CodeMsg;
import com.github.huhangchn.result.Result;
import com.github.huhangchn.result.ResultFactory;
import com.github.huhangchn.service.LoginService;
import com.github.huhangchn.service.RegisterService;
import com.github.huhangchn.service.UserService;
import com.github.huhangchn.util.FileTransUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;


    @Autowired
    private LoginService loginService;

    @Autowired
    private RegisterService registerService;

    @RequestMapping(value = "/checkLogin",method = RequestMethod.GET)
    @ApiOperation(value = "判断用户是否登录")
    public Result checkLogin(@RequestParam(defaultValue = "") String token){
        Member member=loginService.getUserByToken(token);
        return ResultFactory.success(member);
    }

    @RequestMapping(value = "/loginOut",method = RequestMethod.GET)
    @ApiOperation(value = "退出登录")
    public Result logout(@RequestParam(defaultValue = "") String token){
        loginService.logout(token);
        return ResultFactory.success();
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ApiOperation(value = "用户注册")
    public Result register(@RequestBody MemberLoginRegist memberLoginRegist){
        int result=registerService.register(memberLoginRegist.getUserName(), memberLoginRegist.getUserPwd());
        if(result==0){
            return ResultFactory.error(CodeMsg.EMPTY_FIELD);
        }else if(result==1){
            return ResultFactory.error(CodeMsg.USERNAME_EXIST);
        }
        return ResultFactory.success(result);
    }

    @RequestMapping(value = "/uploadAvatar",method = RequestMethod.POST)
    @ApiOperation(value = "用户头像上传")
    public Result uploadAvatar(@RequestBody CommonDto common){
        byte[] imageBytes = FileTransUtil.base64topng(common.getImgData());
        String imgPath = userService.uploadAvatar(common.getUserId(),common.getToken(),imageBytes);
        return ResultFactory.success(imgPath);
    }


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
