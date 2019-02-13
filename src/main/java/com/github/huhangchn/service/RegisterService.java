package com.github.huhangchn.service;

public interface RegisterService {
    /**
     * @return 0: 用户名或密码为空 1: 用户名已存在 100: 注册成功
     */
    int register(String userName, String userPwd);

    boolean usernameExist(String username);
}
