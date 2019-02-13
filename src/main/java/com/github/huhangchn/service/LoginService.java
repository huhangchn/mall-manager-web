package com.github.huhangchn.service;

import com.github.huhangchn.dto.Member;

public interface LoginService {
    void logout(String token);

    Member getUserByToken(String token);
}
