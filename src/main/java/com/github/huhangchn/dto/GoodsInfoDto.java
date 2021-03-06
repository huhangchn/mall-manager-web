package com.github.huhangchn.dto;

import com.github.huhangchn.model.Goods;
import com.github.huhangchn.model.Sku;
import lombok.Data;

import java.util.List;

@Data
public class GoodsInfoDto extends Goods {
    private List<String> galleryList;
    private List<Integer> basicValueId;
    private List<Sku> skuList;
}
