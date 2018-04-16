package com.mall.dao;

import java.util.List;

/**
 * @author liuxiaojie
 *
 * 基本Dao方法接口
 * */
public interface BaseDao {
    void save(Object obj);  //增加数据
    void removeById(Long id);  //根据id删除数据
    void update(Object obj);  //修改数据

    Object getById(Long id);  //根据id查询数据
    List<Object> listAll();  //查询列表中所有数据
    Long count();  //查询数据表中有多少条数据
}
