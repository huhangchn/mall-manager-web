package com.github.huhangchn.dto;

import lombok.Data;

import java.util.List;

@Data
public class GoodsIdValuesDto {
    private Integer goodsId;
    private List<Integer> valueIdList;
}
