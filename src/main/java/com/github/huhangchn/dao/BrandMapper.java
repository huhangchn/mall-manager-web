package com.github.huhangchn.dao;

import com.github.huhangchn.core.Mapper;
import com.github.huhangchn.model.Brand;

import java.util.List;

public interface BrandMapper extends Mapper<Brand> {
    List<Brand> selectByCategory(Integer categoryId);
}