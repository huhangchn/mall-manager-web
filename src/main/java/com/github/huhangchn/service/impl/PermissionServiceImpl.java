package com.github.huhangchn.service.impl;

import com.github.huhangchn.dao.PermissionMapper;
import com.github.huhangchn.model.Permission;
import com.github.huhangchn.service.PermissionService;
import com.github.huhangchn.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by CodeGenerator on 2019/01/27.
 */
@Service
@Transactional
public class PermissionServiceImpl extends AbstractService<Permission> implements PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<Permission> findByUserId(Integer id) {
        return permissionMapper.selectByUserId(id);
    }
}
