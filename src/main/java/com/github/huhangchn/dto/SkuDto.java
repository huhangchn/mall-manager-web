package com.github.huhangchn.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class SkuDto {
    private Integer id;
    private String number;
    private Integer goodsId;
    private String name;
    private String shoeSize;
    private Integer store;
    private BigDecimal price;
    private Date createTime;
}
