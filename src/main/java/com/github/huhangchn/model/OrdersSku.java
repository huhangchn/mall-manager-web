package com.github.huhangchn.model;

import javax.persistence.*;
import java.math.BigDecimal;

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

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取主单id
     *
     * @return orders_id - 主单id
     */
    public Integer getOrdersId() {
        return ordersId;
    }

    /**
     * 设置主单id
     *
     * @param ordersId 主单id
     */
    public void setOrdersId(Integer ordersId) {
        this.ordersId = ordersId;
    }

    /**
     * 获取商品id
     *
     * @return sku_id - 商品id
     */
    public Integer getSkuId() {
        return skuId;
    }

    /**
     * 设置商品id
     *
     * @param skuId 商品id
     */
    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    /**
     * 获取产品名称
     *
     * @return sku_name - 产品名称
     */
    public String getSkuName() {
        return skuName;
    }

    /**
     * 设置产品名称
     *
     * @param skuName 产品名称
     */
    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    /**
     * 获取商品单价
     *
     * @return sku_price - 商品单价
     */
    public BigDecimal getSkuPrice() {
        return skuPrice;
    }

    /**
     * 设置商品单价
     *
     * @param skuPrice 商品单价
     */
    public void setSkuPrice(BigDecimal skuPrice) {
        this.skuPrice = skuPrice;
    }

    /**
     * 获取商品购买数量
     *
     * @return purchase_num - 商品购买数量
     */
    public Integer getPurchaseNum() {
        return purchaseNum;
    }

    /**
     * 设置商品购买数量
     *
     * @param purchaseNum 商品购买数量
     */
    public void setPurchaseNum(Integer purchaseNum) {
        this.purchaseNum = purchaseNum;
    }

    /**
     * 获取商品优惠金额
     *
     * @return discount_price - 商品优惠金额
     */
    public BigDecimal getDiscountPrice() {
        return discountPrice;
    }

    /**
     * 设置商品优惠金额
     *
     * @param discountPrice 商品优惠金额
     */
    public void setDiscountPrice(BigDecimal discountPrice) {
        this.discountPrice = discountPrice;
    }

    /**
     * 获取商品实际金额=商品价格x商品数量-优惠价格
     *
     * @return actual_price - 商品实际金额=商品价格x商品数量-优惠价格
     */
    public BigDecimal getActualPrice() {
        return actualPrice;
    }

    /**
     * 设置商品实际金额=商品价格x商品数量-优惠价格
     *
     * @param actualPrice 商品实际金额=商品价格x商品数量-优惠价格
     */
    public void setActualPrice(BigDecimal actualPrice) {
        this.actualPrice = actualPrice;
    }

    public String getSkuImage() {
        return skuImage;
    }

    public void setSkuImage(String skuImage) {
        this.skuImage = skuImage;
    }

}