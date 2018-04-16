package com.mall.service.impl;

import com.mall.bean.Slider;
import com.mall.dao.SliderDao;
import com.mall.service.SliderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author liuxiaojie
 *
 * 轮播表 service实现类
 * */
@Service
public class SliderServiceImpl implements SliderService {
    @Autowired
    private SliderDao sliderDao;
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public List<Slider> listSliders() {
        List<Slider> sliderList = new ArrayList<>();
        List<Slider> redisList = new ArrayList<>();

        Set<Object> redisSet= redisTemplate.keys("slider-*");
        Long countAll = this.count();
        //说明缓存中有数据
        if (redisSet != null && redisSet.size()==countAll) {
            Iterator<Object> iter = redisSet.iterator();
            while (iter.hasNext()) {
                Slider slider = (Slider) redisTemplate.opsForValue().get(iter.next());
                redisList.add(slider);
            }
            return redisList;
        }else {
            //从数据库中获取数据
            sliderList = sliderDao.listSliders();
            if (sliderList != null && sliderList.size() != 0 ) {
                Iterator iter = sliderList.iterator();
                while (iter.hasNext()) {
                    Slider slider = (Slider) iter.next();
                    redisTemplate.opsForValue().set("slider-"+slider.getSid(),slider);
                }
            }
            return sliderList;
        }
    }

    @Override
    public Long count() {
        return sliderDao.count();
    }

    @Override
    public Slider getById(Long sid) {
        Slider slider = null;
        slider = (Slider) redisTemplate.opsForValue().get("slider-"+sid);
        //若缓存中没有对应的数据则去数据库中查找，若有此数据则直接从缓存中取值
        if (slider == null) {
            slider = sliderDao.getById(sid);
            if (slider != null) {
                redisTemplate.opsForValue().set("slider-"+sid,slider);
            }
        }
        return slider;
    }

    @Override
    public void update(Slider slider) {
        Long sid = slider.getSid();
        try{
            //判断主键id是否有值
            if (sid != null){
                //先修改数据库中的值，修改成功后先查缓存中是否存在此条数据再修改
                sliderDao.update(slider);
                if (redisTemplate.opsForValue().get("slider-"+sid)!=null){
                    redisTemplate.opsForValue().set("slider-"+sid,slider);
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
