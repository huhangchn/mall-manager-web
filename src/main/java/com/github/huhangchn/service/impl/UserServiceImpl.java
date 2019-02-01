package com.github.huhangchn.service.impl;

import com.github.huhangchn.core.AbstractService;
import com.github.huhangchn.dao.UserMapper;
import com.github.huhangchn.model.User;
import com.github.huhangchn.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by CodeGenerator on 2019/01/26.
 */
@Service
@Transactional
public class UserServiceImpl extends AbstractService<User> implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByUsername(String userName) {
        return userMapper.selectByUsername(userName);
    }

    @SuppressWarnings("unchecked")
    @Override
    public PageInfo<User> findAll(User user, Integer page, Integer size) {
        PageHelper.startPage(page, size);
        return new PageInfo( userMapper.select(user));
    }
}
