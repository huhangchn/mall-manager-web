package com.github.huhangchn.service.impl;

import com.github.huhangchn.core.AbstractService;
import com.github.huhangchn.dao.CategoryMapper;
import com.github.huhangchn.dto.CategoryDto;
import com.github.huhangchn.model.Category;
import com.github.huhangchn.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by CodeGenerator on 2019/01/26.
 */
@Service
@Transactional
public class CategoryServiceImpl extends AbstractService<Category> implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<CategoryDto> getTree() {
        List<CategoryDto> categoryDtoList = categoryMapper.findAllToCategoryDto();
        Map<Integer, CategoryDto> map = new LinkedHashMap<>();//保持有序
        categoryDtoList.forEach(category -> map.put(category.getValue(), category));
        map.forEach((id, categoryDto) -> {
            Integer pId = categoryDto.getPId();
            if (pId != null && pId != 0) {
                map.get(pId).addChild(categoryDto);
            }
        });
        return categoryDtoList.stream().filter(categoryDto -> categoryDto.getPId() == 0).collect(Collectors.toList());
    }
}
