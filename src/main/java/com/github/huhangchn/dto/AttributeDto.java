package com.github.huhangchn.dto;

import com.github.huhangchn.model.Attribute;
import com.github.huhangchn.model.AttributeValue;

import java.util.List;

public class AttributeDto extends Attribute {
    private List<AttributeValue> attributeValue;

    public List<AttributeValue> getAttributeValue() {
        return attributeValue;
    }

    public void setAttributeValue(List<AttributeValue> attributeValue) {
        this.attributeValue = attributeValue;
    }
}
