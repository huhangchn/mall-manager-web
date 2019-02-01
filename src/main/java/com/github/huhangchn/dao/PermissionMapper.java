package com.github.huhangchn.dao;

import com.github.huhangchn.core.Mapper;
import com.github.huhangchn.model.Permission;

import java.util.List;

public interface PermissionMapper extends Mapper<Permission> {
    List<Permission> selectByUserId(Integer userId);
}