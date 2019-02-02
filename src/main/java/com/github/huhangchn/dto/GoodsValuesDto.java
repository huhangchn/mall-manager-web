package com.github.huhangchn.dto;

import com.github.huhangchn.model.Goods;
import lombok.Data;

import java.util.List;

@Data
public class GoodsValuesDto extends Goods {
    private List<Integer> basicValueId;
}
