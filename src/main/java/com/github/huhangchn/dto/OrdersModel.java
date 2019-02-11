package com.github.huhangchn.dto;

import com.github.huhangchn.model.Orders;
import com.github.huhangchn.model.OrdersSku;

import java.util.List;

public class OrdersModel extends Orders {
    private List<OrdersSku> ordersSkuList;

    public List<OrdersSku> getOrdersSkuList() {
        return ordersSkuList;
    }

    public void setOrdersSkuList(List<OrdersSku> ordersSkuList) {
        this.ordersSkuList = ordersSkuList;
    }
}
