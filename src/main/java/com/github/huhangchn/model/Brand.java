package com.github.huhangchn.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Data
@Accessors(chain = true)
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 品牌名称
     */
    private String name;

    /**
     * 品牌介绍
     */
    private String description;

    /**
     * 品牌商标
     */
    @Column(name = "pic_url")
    private String picUrl;

    @Column(name = "sort_order")
    private Integer sortOrder;
}