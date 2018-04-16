package com.mall.service;

import com.mall.bean.Details;

import java.util.List;

/**
 * @author liuxiaojie
 *
 * 详情表  Service接口
 * */
public interface DetailsService extends BaseService {
    List<Details> listByVid(Long vid);  //根据分类表id获取list

}
