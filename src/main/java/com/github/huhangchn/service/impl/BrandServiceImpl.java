package com.github.huhangchn.service.impl;

import com.github.huhangchn.dao.BrandMapper;
import com.github.huhangchn.model.Brand;
import com.github.huhangchn.service.BrandService;
import com.github.huhangchn.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by CodeGenerator on 2019/01/27.
 */
@Service
@Transactional
public class BrandServiceImpl extends AbstractService<Brand> implements BrandService {
    @Autowired
    private BrandMapper brandMapper;

    @Override
    public List<Brand> findByCategory(Integer categoryId) {
        if(categoryId != null){
            return brandMapper.selectByCategory(categoryId);
        }else{
            return brandMapper.selectAll();
        }
    }
}
