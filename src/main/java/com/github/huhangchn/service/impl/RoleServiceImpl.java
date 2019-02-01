package com.github.huhangchn.service.impl;

import com.github.huhangchn.dao.RoleMapper;
import com.github.huhangchn.model.Role;
import com.github.huhangchn.service.RoleService;
import com.github.huhangchn.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by CodeGenerator on 2019/01/27.
 */
@Service
@Transactional
public class RoleServiceImpl extends AbstractService<Role> implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

}
