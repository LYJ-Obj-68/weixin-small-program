package com.mall.service;

import java.util.List;

/**
 * @author liuxiaojie
 *
 * 基本Service方法接口
 * */
public interface BaseService {
    void save(Object obj);  //增加数据
    void removeById(Long id);  //根据id删除数据
    void update(Object obj);  //修改数据

    Object getById(Long id);  //根据id查询数据
    List<Object> listAll();  //查询列表中所有数据
    Long count();  //查询数据表中有多少条数据
}
