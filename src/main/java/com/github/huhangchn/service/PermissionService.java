package com.github.huhangchn.service;

import com.github.huhangchn.model.Permission;
import com.github.huhangchn.core.Service;

import java.util.List;


/**
 * Created by CodeGenerator on 2019/01/27.
 */
public interface PermissionService extends Service<Permission> {

    List<Permission> findByUserId(Integer id);
}
