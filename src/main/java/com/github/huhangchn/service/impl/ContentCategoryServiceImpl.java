package com.github.huhangchn.service.impl;

import com.github.huhangchn.dao.ContentCategoryMapper;
import com.github.huhangchn.model.ContentCategory;
import com.github.huhangchn.service.ContentCategoryService;
import com.github.huhangchn.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

/**
* Created by CodeGenerator on 2019/02/13.
*/
@Service
@Transactional
public class ContentCategoryServiceImpl extends AbstractService<ContentCategory> implements ContentCategoryService {
    @Autowired
    private ContentCategoryMapper contentCategoryMapper;

}
