package com.mall.service;

import com.mall.bean.Slider;

import java.util.List;

/**
 * @author liuxiaojie
 *
 * 轮播表 service接口
 * */
public interface SliderService {
    List<Slider> listSliders();  //遍历轮播表
    Long count();  //获取表中总共有多少条数据

    Slider getById (Long sid);  //根据id查询对象
    void update(Slider slider);  //修改对象信息
}
