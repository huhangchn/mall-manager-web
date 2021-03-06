package com.github.huhangchn.service.impl;

import com.github.huhangchn.dao.ContentMapper;
import com.github.huhangchn.model.Content;
import com.github.huhangchn.service.ContentService;
import com.github.huhangchn.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

/**
* Created by CodeGenerator on 2019/02/13.
*/
@Service
@Transactional
public class ContentServiceImpl extends AbstractService<Content> implements ContentService {
    @Autowired
    private ContentMapper contentMapper;

}
