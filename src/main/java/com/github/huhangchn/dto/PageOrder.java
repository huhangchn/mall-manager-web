package com.github.huhangchn.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @author Exrickx
 */
public class PageOrder implements Serializable{

    private int total;

    private List<OrderDto> data;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<OrderDto> getData() {
        return data;
    }

    public void setData(List<OrderDto> data) {
        this.data = data;
    }
}
