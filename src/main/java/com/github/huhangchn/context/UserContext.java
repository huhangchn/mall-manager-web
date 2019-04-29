package com.github.huhangchn.context;

import java.util.HashMap;
import java.util.Map;

public class UserContext {
    private static final Map<String, Integer> tokenMap = new HashMap<>();

    public static Integer putUserId(String token, Integer userId) {
        return tokenMap.put(token, userId);
    }

    public static Integer getUserId(String token) {
        return tokenMap.get(token);
    }

    public static void removeUserId(String token) {
        tokenMap.remove(token);
    }
}
