package com.github.huhangchn.service.impl;

import com.github.huhangchn.dao.OrdersSkuMapper;
import com.github.huhangchn.model.OrdersSku;
import com.github.huhangchn.service.OrdersSkuService;
import com.github.huhangchn.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

/**
* Created by CodeGenerator on 2019/01/29.
*/
@Service
@Transactional
public class OrdersSkuServiceImpl extends AbstractService<OrdersSku> implements OrdersSkuService {
    @Autowired
    private OrdersSkuMapper ordersSkuMapper;

}
