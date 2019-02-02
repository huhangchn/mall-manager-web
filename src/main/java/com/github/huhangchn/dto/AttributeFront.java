package com.github.huhangchn.dto;

import lombok.Data;

import java.util.List;

@Data
public class AttributeFront {
    private Integer attributeId;
    private String name;
    private List<ValueFront> list;
}
