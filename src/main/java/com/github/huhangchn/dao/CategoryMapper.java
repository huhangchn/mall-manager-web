package com.github.huhangchn.dao;

import com.github.huhangchn.core.Mapper;
import com.github.huhangchn.dto.CategoryDto;
import com.github.huhangchn.model.Category;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CategoryMapper extends Mapper<Category> {
    @Select(value = "select * from category order by sort_order")
    @ResultMap("categoryOptions")
    List<CategoryDto> findAllToCategoryDto();
}