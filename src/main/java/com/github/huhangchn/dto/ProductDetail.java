package com.github.huhangchn.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ProductDetail {
    private Integer productId;
    private BigDecimal salePrice;
    private String productName;
    private String subTitle;
    private Integer limitNum = 100;
    private String productImageBig;
    private String detail;
    private List<String> productImageSmall;
}
