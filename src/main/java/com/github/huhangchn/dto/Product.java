package com.github.huhangchn.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Product {
    private Integer productId;
    private BigDecimal salePrice;
    private String productName;
    private String subTitle;
    private String productImageBig;
}
