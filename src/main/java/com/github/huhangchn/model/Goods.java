package com.github.huhangchn.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Accessors(chain = true)
public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 商品编号
     */
    private String number;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 所属类目
     */
    @Column(name = "category_id")
    private Integer categoryId;

    /**
     * 所属品牌
     */
    @Column(name = "brand_id")
    private Integer brandId;

    /**
     * 商品简介
     */
    private String brief;

    /**
     * 商品页面商品图片
     */
    @Column(name = "pic_url")
    private String picUrl;

    /**
     * 商品画廊
     */
    private String gallery;
    /**
     * 商品详情
     */
    private String detail;
    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 是否上架
     */
    @Column(name = "is_on_sale")
    private Boolean isOnSale;

    /**
     * 商品价格
     */
    @Column(name = "price")
    private BigDecimal price;

}