package com.github.huhangchn.dto;

import com.github.huhangchn.model.Goods;
import com.github.huhangchn.model.Sku;

public class SkuDto extends Sku {
    private Goods goods;

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }
}
