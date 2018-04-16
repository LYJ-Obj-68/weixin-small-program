package com.mall.dao;

import com.mall.bean.Details;

import java.util.List;

/**
 * @author liuxiaojie
 *
 * 详情表  Dao接口
 * */
public interface DetailsDao extends BaseDao {
    List<Details> listByVid(Long vid);  //根据分类表id获取list
}
