package com.github.huhangchn.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class CartDto implements Serializable{
    private Integer id;

    private Long skuId;

    private Long productId;

    private BigDecimal salePrice;

    private Long num;

    private String productName;

    private String productImg;

    private String checked;

}
