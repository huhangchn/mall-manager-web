package com.github.huhangchn.dto;

import lombok.Data;

import java.util.List;

@Data
public class GoodsFrontSearchDto {
    private List<Integer> valueIds;
    private Integer brandId;
    private Integer categoryId;
    Integer page = 1;
    Integer size = 20;
    String sort = "";
    Long cid = null;
    Integer priceGt = -1;
    Integer priceLte = -1;
}
