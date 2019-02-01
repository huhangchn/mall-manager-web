package com.github.huhangchn.model;

import javax.persistence.*;

@Table(name = "attribute_value")
public class AttributeValue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 属性名id
     */
    @Column(name = "attribute_id")
    private Integer attributeId;

    /**
     * 属性值
     */
    private String value;

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
     * 获取属性名id
     *
     * @return attribute_id - 属性名id
     */
    public Integer getAttributeId() {
        return attributeId;
    }

    /**
     * 设置属性名id
     *
     * @param attributeId 属性名id
     */
    public void setAttributeId(Integer attributeId) {
        this.attributeId = attributeId;
    }

    /**
     * 获取属性值
     *
     * @return value - 属性值
     */
    public String getValue() {
        return value;
    }

    /**
     * 设置属性值
     *
     * @param value 属性值
     */
    public void setValue(String value) {
        this.value = value;
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