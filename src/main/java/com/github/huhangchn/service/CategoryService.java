package com.github.huhangchn.service;

import com.github.huhangchn.core.Service;
import com.github.huhangchn.dto.CategoryDto;
import com.github.huhangchn.model.Category;

import java.util.List;

/**
 * Created by CodeGenerator on 2019/01/26.
 */
public interface CategoryService extends Service<Category> {

    /**
     * 获取所有树形数据
     */
    List<CategoryDto> getTree();
}
