package com.github.huhangchn.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;

@Data
public class Cart {
    @Id
    private Integer id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 产品id
     */
    @Column(name = "sku_id")
    private Integer skuId;

    /**
     * 产品购物数量
     */
    private Integer num;

    private String checked;
}