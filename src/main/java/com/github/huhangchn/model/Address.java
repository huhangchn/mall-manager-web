package com.github.huhangchn.model;

import lombok.Data;

import javax.persistence.*;

@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户表的用户ID
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 收货人名称
     */
    private String name;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 行政区域表的省ID
     */
    @Column(name = "province_id")
    private Integer provinceId;

    /**
     * 行政区域表的市ID
     */
    @Column(name = "city_id")
    private Integer cityId;

    /**
     * 行政区域表的区县ID
     */
    @Column(name = "area_id")
    private Integer areaId;

    /**
     * 具体收货地址
     */
    private String address;

    /**
     * 是否默认地址
     */
    @Column(name = "is_default")
    private Boolean isDefault;

}