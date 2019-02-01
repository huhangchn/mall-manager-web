package com.github.huhangchn.model;

import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "shoe_size")
public class ShoeSize {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private BigDecimal size;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return size
     */
    public BigDecimal getSize() {
        return size;
    }

    /**
     * @param size
     */
    public void setSize(BigDecimal size) {
        this.size = size;
    }
}