package com.github.huhangchn.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Attribute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 属性名名称
     */
    private String name;

    /**
     * 类目id
     */
    @Column(name = "category_id")
    private Integer categoryId;

    /**
     * 0基本属性；1销售属性
     */
    private String type;

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
     * 获取属性名名称
     *
     * @return name - 属性名名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置属性名名称
     *
     * @param name 属性名名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取类目id
     *
     * @return category_id - 类目id
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * 设置类目id
     *
     * @param categoryId 类目id
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 获取0基本属性；1销售属性
     *
     * @return type - 0基本属性；1销售属性
     */
    public String getType() {
        return type;
    }

    /**
     * 设置0基本属性；1销售属性
     *
     * @param type 0基本属性；1销售属性
     */
    public void setType(String type) {
        this.type = type;
    }
}