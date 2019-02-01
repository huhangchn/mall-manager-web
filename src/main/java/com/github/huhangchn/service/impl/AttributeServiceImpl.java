package com.github.huhangchn.service.impl;

import com.github.huhangchn.dao.AttributeMapper;
import com.github.huhangchn.dto.AttributeDto;
import com.github.huhangchn.model.Attribute;
import com.github.huhangchn.service.AttributeService;
import com.github.huhangchn.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
* Created by CodeGenerator on 2019/01/29.
*/
@Service
@Transactional
public class AttributeServiceImpl extends AbstractService<Attribute> implements AttributeService {
    @Autowired
    private AttributeMapper attributeMapper;

    @Override
    public List<AttributeDto> findBasicOptions() {
        return attributeMapper.selectBasicOptions();
    }
}
