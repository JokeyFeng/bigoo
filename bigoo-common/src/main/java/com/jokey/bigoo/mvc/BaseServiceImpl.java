package com.jokey.bigoo.mvc;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author Zhengjingfeng
 * created 2019/6/19 11:30
 * comment
 */
public abstract class BaseServiceImpl<T> implements BaseService<T> {
    /**
     * 实例化
     *
     * @return
     */
    protected abstract MyMapper<T> getMapper();

    @Override
    public List<T> selectAll() {
        return getMapper().selectAll();
    }

    @Override
    public T selectByKey(Object key) {
        return getMapper().selectByPrimaryKey(key);
    }

    @Override
    public PageInfo<T> selectByPage(Page page) {
        return PageHelper.startPage(page.getPageNum(), page.getPageSize()).setOrderBy(page.getOrderBy())
                .doSelectPageInfo(() -> getMapper().selectAll());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int save(T entity) {
        return getMapper().insert(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int batchSave(List<? extends T> list) {
        return getMapper().insertList(list);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int delete(Object key) {
        return getMapper().deleteByPrimaryKey(key);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int batchDelete(List<String> list, String property, Class<T> clazz) {
        Example example = new Example(clazz);
        example.createCriteria().andIn(property, list);
        return getMapper().deleteByExample(example);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateAll(T entity) {
        return getMapper().updateByPrimaryKey(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateNotNull(T entity) {
        return getMapper().updateByPrimaryKeySelective(entity);
    }

    @Override
    public List<T> selectByExample(Object example) {
        return getMapper().selectByExample(example);
    }
}
