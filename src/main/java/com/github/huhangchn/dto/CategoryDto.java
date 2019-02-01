package com.github.huhangchn.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

@Data
@Accessors(chain = true)
public class CategoryDto{
    private Integer value;
    private String label;
    private Integer pId;
    private List<CategoryDto> children;

    public List<CategoryDto> getChildren() {
        return children;
    }

    public CategoryDto addChild(CategoryDto categoryDto) {
        if (children == null) {
            children = new ArrayList<>();
        }
        children.add(categoryDto);
        return categoryDto;
    }
}
