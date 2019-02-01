package com.github.huhangchn.service.impl;

import com.github.huhangchn.dao.AttributeValueMapper;
import com.github.huhangchn.model.AttributeValue;
import com.github.huhangchn.service.AttributeValueService;
import com.github.huhangchn.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

/**
* Created by CodeGenerator on 2019/01/29.
*/
@Service
@Transactional
public class AttributeValueServiceImpl extends AbstractService<AttributeValue> implements AttributeValueService {
    @Autowired
    private AttributeValueMapper attributeValueMapper;

}
