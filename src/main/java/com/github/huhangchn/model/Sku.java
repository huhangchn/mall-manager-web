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
public class Sku {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * sku产品编号
     */
    private String number;

    /**
     * 商品id
     */
    @Column(name = "goods_id")
    private Integer goodsId;

    /**
     * sku名称
     */
    private String name;

    /**
     * 库存数量
     */
    private Integer store;

    /**
     * 价格
     */
    private BigDecimal price;

    @Column(name = "shoe_size")
    private String shoeSize;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

}