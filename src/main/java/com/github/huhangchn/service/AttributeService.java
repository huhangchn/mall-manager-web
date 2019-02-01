package com.github.huhangchn.service;

import com.github.huhangchn.core.Service;
import com.github.huhangchn.dto.AttributeDto;
import com.github.huhangchn.model.Attribute;

import java.util.List;


/**
* Created by CodeGenerator on 2019/01/29.
*/
public interface AttributeService extends Service<Attribute> {

    List<AttributeDto> findBasicOptions();
}
