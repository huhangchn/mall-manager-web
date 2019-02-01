package com.github.huhangchn.service.impl;

import com.github.huhangchn.dao.OrdersMapper;
import com.github.huhangchn.model.Orders;
import com.github.huhangchn.service.OrdersService;
import com.github.huhangchn.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

/**
* Created by CodeGenerator on 2019/01/29.
*/
@Service
@Transactional
public class OrdersServiceImpl extends AbstractService<Orders> implements OrdersService {
    @Autowired
    private OrdersMapper ordersMapper;

}
