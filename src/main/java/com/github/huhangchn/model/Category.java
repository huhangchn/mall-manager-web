package com.github.huhangchn.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Data
@Accessors(chain = true)
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 父类目id
     */
    @Column(name = "p_id")
    private Integer pId;

    /**
     * 类目名称
     */
    private String name;

    /**
     * 0不是，1是
     */
    @Column(name = "is_parent")
    private Boolean isParent;

    /**
     * 类目排序
     */
    @Column(name = "sort_order")
    private Integer sortOrder;
}