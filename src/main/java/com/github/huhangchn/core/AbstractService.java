package com.github.huhangchn.core;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.entity.Condition;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * 基于通用MyBatis Mapper插件的Service接口的实现
 */
public abstract class AbstractService<T> implements Service<T> {
    private final static Logger LOGGER = LoggerFactory.getLogger(AbstractService.class);

    @Autowired
    protected Mapper<T> mapper;

    private Class<T> modelClass;    // 当前泛型真实类型的Class

    @SuppressWarnings("unchecked")
    public AbstractService() {
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        modelClass = (Class<T>) pt.getActualTypeArguments()[0];
    }

    public int saveSelective(T model) {
        return mapper.insertSelective(model);
    }

    public int saveSelective(List<T> models) {
        return mapper.insertList(models);
    }

    public int deleteById(Integer id) {
        return mapper.deleteByPrimaryKey(id);
    }

    public int deleteByIds(String ids) {
        return mapper.deleteByIds(ids);
    }

    public int updateByPrimaryKeySelective(T model) {
        return mapper.updateByPrimaryKeySelective(model);
    }

    public T findById(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public T findBy(String fieldName, Object value) throws TooManyResultsException {
        try {
            T model = modelClass.newInstance();
            Field field = modelClass.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(model, value);
            return mapper.selectOne(model);
        } catch (ReflectiveOperationException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public List<T> findByIds(String ids) {
        return mapper.selectByIds(ids);
    }

    public List<T> findByCondition(Condition condition) {
        return mapper.selectByCondition(condition);
    }

    public List<T> findAll() {
        return mapper.selectAll();
    }

    @SuppressWarnings("unchecked")
    public PageInfo<T> findAll(Integer page, Integer size) {
        PageHelper.startPage(page, size);
        List<T> list = mapper.selectAll();
        return new PageInfo(list);
    }

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @SuppressWarnings({"unchecked", "rawtypes"})
    @Override
    public int updateBatch(List<T> list) {
        int eachCommitCount = 3000;
        //非空判断
        if (list == null || list.isEmpty()) {
            return 0;
        }
        SqlSession session = null;
        try {
            //提取当前service对象泛型实体类对应的Mapper类
            Class mapperClass = genericMapperClass();
            if (mapperClass == null) {
                //更新数据时候无法取得mapperClass
                return 0;
            }
            // 新获取一个模式为BATCH，自动提交为false的session
            // 如果自动提交设置为true,将无法控制提交的条数，改为最后统一提交，可能导致内存溢出
            session = sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH, false);
            //通过新的session获取mapper
            BaseMapper<T> mapper = (BaseMapper) session.getMapper(mapperClass);

            //批量更新数据处理
            for (int i = 0; i < list.size(); i++) {
                mapper.updateByPrimaryKeySelective(list.get(i));
                if (i % eachCommitCount == 0 || i == list.size() - 1) {
                    //手动每 eachCommitCount 个一提交，提交后无法回滚
                    session.commit();
                    //清理缓存，防止溢出
                    session.clearCache();
                }
            }
        } catch (Exception e) {
            if (session != null) {
                session.rollback();
            }
            LOGGER.error("批量更新出错", e);
            return 0;
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return 0;
    }

    /**
     * 获取当前Service对象泛型实体类的对应Mapper类
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    private Class genericMapperClass() {
        try {
            //提取当前service对象泛型实例化类对应的Mapper类
            Class<T> modelClass = (Class<T>) getClass().getGenericSuperclass();
            String modelClassName = modelClass.getName();
            String mapperClassName = modelClassName.replace("model", "dao") + "Mapper";
            Class mapperClass;
            mapperClass = Class.forName(mapperClassName);
            return mapperClass;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int count() {
        return mapper.selectCount(null);
    }

    @Override
    public PageInfo<T> findAll(T model, Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        return new PageInfo<>(mapper.select(model));
    }

    @Override
    public PageInfo<T> findAll(Condition condition, Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        return new PageInfo<>(mapper.selectByCondition(condition));
    }
}
