package com.github.huhangchn.model;

import javax.persistence.*;

@Table(name = "goods_attribute_value")
public class GoodsAttributeValue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 商品id
     */
    @Column(name = "goods_id")
    private Integer goodsId;

    /**
     * 属性值id
     */
    @Column(name = "value_id")
    private Integer valueId;

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
     * 获取商品id
     *
     * @return goods_id - 商品id
     */
    public Integer getGoodsId() {
        return goodsId;
    }

    /**
     * 设置商品id
     *
     * @param goodsId 商品id
     */
    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * 获取属性值id
     *
     * @return value_id - 属性值id
     */
    public Integer getValueId() {
        return valueId;
    }

    /**
     * 设置属性值id
     *
     * @param valueId 属性值id
     */
    public void setValueId(Integer valueId) {
        this.valueId = valueId;
    }
}