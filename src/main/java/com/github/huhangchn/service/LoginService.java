package com.github.huhangchn.service;

import com.github.huhangchn.dto.Member;
import com.github.huhangchn.dto.MemberLoginRegist;

public interface LoginService {
    void logout(String token);

    Member getUserByToken(String token);

    Member login(MemberLoginRegist memberLoginRegist);
}
