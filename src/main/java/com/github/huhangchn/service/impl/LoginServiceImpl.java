package com.github.huhangchn.service.impl;

import com.github.huhangchn.dto.DtoUtil;
import com.github.huhangchn.dto.Member;
import com.github.huhangchn.model.User;
import com.github.huhangchn.service.LoginService;
import com.github.huhangchn.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserService userService;
    @Override
    public void logout(String token) {

    }

    @Override
    public Member getUserByToken(String token) {
        if(StringUtils.isEmpty(token)){
            Member member=new Member();
            member.setState(0);
            member.setMessage("用户登录已过期");
            return member;
        }
        User user = userService.findById(62);
        return DtoUtil.user2Member(user);
    }
}
