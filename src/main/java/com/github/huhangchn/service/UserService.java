package com.github.huhangchn.service;

import com.github.huhangchn.core.Service;
import com.github.huhangchn.model.User;
import com.github.pagehelper.PageInfo;


/**
 * Created by CodeGenerator on 2019/01/26.
 */
public interface UserService extends Service<User> {

    User findByUsername(String userName);

    PageInfo<User> findAll(User user, Integer page, Integer size);
}
