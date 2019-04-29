package com.github.huhangchn.service.impl;

import com.github.huhangchn.context.UserContext;
import com.github.huhangchn.core.ServiceException;
import com.github.huhangchn.dao.UserMapper;
import com.github.huhangchn.dto.DtoUtil;
import com.github.huhangchn.dto.Member;
import com.github.huhangchn.dto.MemberLoginRegist;
import com.github.huhangchn.model.User;
import com.github.huhangchn.result.CodeMsg;
import com.github.huhangchn.result.ResultFactory;
import com.github.huhangchn.service.LoginService;
import com.github.huhangchn.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserService userService;
    @Override
    public void logout(String token) {
        UserContext.removeUserId(token);
    }

    @Override
    public Member getUserByToken(String token) {
        Integer userId = UserContext.getUserId(token);
        if(StringUtils.isEmpty(token) || null == userId){
            Member member=new Member();
            member.setState(0);
            member.setMessage("用户登录已过期");
            return member;
        }
        User user = userService.findById(userId);
        return DtoUtil.user2Member(user);
    }
    @Autowired
    UserMapper userMapper;
    @Override
    public Member login(MemberLoginRegist memberLoginRegist) {
        String userName = memberLoginRegist.getUserName();
        String userPwd = memberLoginRegist.getUserPwd();
        if(userName== null || userPwd == null || userName.length() < 6 || userName.length() > 12 || userPwd.length() <6 || userPwd.length() >12 ){
            throw new ServiceException(ResultFactory.error(CodeMsg.INPUT_ERROR));
        }

        User user = new User().setUsername(userName).setPassword(userPwd);
        User user1 = userMapper.selectOne(user);
        if(user1 == null){
            throw new ServiceException(ResultFactory.error(CodeMsg.PASSWORD_ERROR));
        }
        Member member = new Member();
        member.setState(1);
        member.setId((long) (user1.getId()));
        String token = UUID.randomUUID().toString();
        member.setToken(token);

        UserContext.putUserId(token, user1.getId());
        return member;
    }
}
