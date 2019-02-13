package com.github.huhangchn.model;

import javax.persistence.*;

@Table(name = "content_category")
public class ContentCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 父板块id
     */
    @Column(name = "parent_id")
    private Integer parentId;

    /**
     * 板块名称
     */
    private String name;

    /**
     * 板块状态
     */
    private Integer status;

    /**
     * 排序
     */
    @Column(name = "sort_order")
    private Integer sortOrder;

    /**
     * 是否父板块
     */
    @Column(name = "is_parent")
    private String isParent;

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
     * 获取父板块id
     *
     * @return parent_id - 父板块id
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 设置父板块id
     *
     * @param parentId 父板块id
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取板块名称
     *
     * @return name - 板块名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置板块名称
     *
     * @param name 板块名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取板块状态
     *
     * @return status - 板块状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置板块状态
     *
     * @param status 板块状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取排序
     *
     * @return sort_order - 排序
     */
    public Integer getSortOrder() {
        return sortOrder;
    }

    /**
     * 设置排序
     *
     * @param sortOrder 排序
     */
    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    /**
     * 获取是否父板块
     *
     * @return is_parent - 是否父板块
     */
    public String getIsParent() {
        return isParent;
    }

    /**
     * 设置是否父板块
     *
     * @param isParent 是否父板块
     */
    public void setIsParent(String isParent) {
        this.isParent = isParent;
    }
}