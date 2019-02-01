package com.github.huhangchn.dao;

import com.github.huhangchn.core.Mapper;
import com.github.huhangchn.dto.AttributeDto;
import com.github.huhangchn.model.Attribute;

import java.util.List;

public interface AttributeMapper extends Mapper<Attribute> {
    List<AttributeDto> selectBasicOptions();
}