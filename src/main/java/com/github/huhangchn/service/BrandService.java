package com.github.huhangchn.service;

import com.github.huhangchn.core.Service;
import com.github.huhangchn.model.Brand;

import java.util.List;


/**
 * Created by CodeGenerator on 2019/01/27.
 */
public interface BrandService extends Service<Brand> {

    List<Brand> findByCategory(Integer categoryId);
}
