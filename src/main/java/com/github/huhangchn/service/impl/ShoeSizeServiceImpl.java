package com.github.huhangchn.service.impl;

import com.github.huhangchn.dao.ShoeSizeMapper;
import com.github.huhangchn.model.ShoeSize;
import com.github.huhangchn.service.ShoeSizeService;
import com.github.huhangchn.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

/**
* Created by CodeGenerator on 2019/01/31.
*/
@Service
@Transactional
public class ShoeSizeServiceImpl extends AbstractService<ShoeSize> implements ShoeSizeService {
    @Autowired
    private ShoeSizeMapper shoeSizeMapper;

}
