package com.github.huhangchn.service.impl;

import com.github.huhangchn.core.ServiceException;
import com.github.huhangchn.dao.UserMapper;
import com.github.huhangchn.model.User;
import com.github.huhangchn.result.CodeMsg;
import com.github.huhangchn.result.ResultFactory;
import com.github.huhangchn.service.RegisterService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RegisterServiceImpl implements RegisterService{

    @Autowired
    UserMapper userMapper;

    @Override
    public int register(String userName, String userPwd) {
        if(StringUtils.isEmpty(userName) || StringUtils.isEmpty(userPwd)){
            return 0;
        }
        if(userName.length() < 6 || userName.length() > 12 || userPwd.length() <6 || userPwd.length() >12 ){
            throw new ServiceException(ResultFactory.error(CodeMsg.INPUT_ERROR));
        }
        User user = new User();
        user.setUsername(userName);
        user.setPassword(userPwd);
        if(usernameExist(userName)){
            return 1;
        }
        userMapper.insertSelective(user);
        return 100;
    }

    @Override
    public boolean usernameExist(String username) {
        User user = new User();
        user.setUsername(username);
        int i = userMapper.selectCount(user);
        return i >= 1;
    }
}
