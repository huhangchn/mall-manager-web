//package com.github.huhangchn.service.impl;
//
//
//import com.github.huhangchn.model.User;
//import com.github.huhangchn.service.MemberService;
//import com.github.huhangchn.util.QiniuUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
///**
// * @author Exrickx
// */
//@Service
//public class MemberServiceImpl implements MemberService {
//
//    @Autowired
//    private UserServiceImpl userService;
//
//    @Override
//    public String imageUpload(Long userId,String token,String imgData) {
//        //过滤data:URL
//        String base64= QiniuUtil.base64Data(imgData);
//        String imgPath= QiniuUtil.qiniuBase64Upload(base64);
//        userService.updateByPrimaryKeySelective(new User().setId(userId.intValue()).setAvatarUrl(imgPath));
//        return imgPath;
//    }
//}