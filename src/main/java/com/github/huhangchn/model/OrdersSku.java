package com.github.huhangchn.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Table(name = "orders_sku")
public class OrdersSku {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 主单id
     */
    @Column(name = "orders_id")
    private Integer ordersId;

    /**
     * 商品id
     */
    @Column(name = "sku_id")
    private Integer skuId;

    /**
     * 产品名称
     */
    @Column(name = "sku_name")
    private String skuName;

    /**
     * 产品图片
     */
    @Column(name = "sku_image")
    private String skuImage;

    /**
     * 产品舒属性详情
     */
    @Column(name = "sku_attr")
    private String skuAttr;

    /**
     * 商品单价
     */
    @Column(name = "sku_price")
    private BigDecimal skuPrice;

    /**
     * 商品购买数量
     */
    @Column(name = "purchase_num")
    private Integer purchaseNum;

    /**
     * 商品优惠金额
     */
    @Column(name = "discount_price")
    private BigDecimal discountPrice;

    /**
     * 商品实际金额=商品价格x商品数量-优惠价格
     */
    @Column(name = "actual_price")
    private BigDecimal actualPrice;

}