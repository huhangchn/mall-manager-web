package com.github.huhangchn.core;

import com.github.pagehelper.PageInfo;
import org.apache.ibatis.exceptions.TooManyResultsException;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;

/**
 * Service 层 基础接口，其他Service 接口 请继承该接口
 */
public interface Service<T> {
    /**
     * 持久化
     */
    int saveSelective(T model);

    /**
     * 批量持久化
     */
    int saveSelective(List<T> models);

    /**
     * 通过主鍵刪除
     */
    int deleteById(Integer id);//

    /**
     * 批量刪除 eg：ids -> “1,2,3,4”
     */
    int deleteByIds(String ids);

    /**
     * 更新
     */
    int updateByPrimaryKeySelective(T model);

    /**
     * 批量更新
     *
     * @return -99 异常
     */
    int updateBatch(List<T> models);

    /**
     * 通过ID查找
     */
    T findById(Integer id);

    /**
     * 通过Model中某个成员变量名称（非数据表中column的名称）查找,value需符合unique约束
     */
    T findBy(String fieldName, Object value) throws TooManyResultsException;

    /**
     * 通过多个ID查找//eg：ids -> “1,2,3,4”
     */
    List<T> findByIds(String ids);

    /**
     * 根据条件查找
     */
    List<T> findByCondition(Condition condition);

    /**
     * 获取所有
     */
    List<T> findAll();

    /**
     * 简单分页查找
     */
    PageInfo<T> findAll(Integer page, Integer size);

    /**
     *  总记录数
     */
    int count();

    PageInfo<T> findAll(T model, Integer page, Integer limit);

    PageInfo<T> findAll(Condition condition, Integer page, Integer limit);
}
