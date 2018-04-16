package com.mall.service.impl;

import com.mall.bean.Venues;
import com.mall.dao.VenuesDao;
import com.mall.service.VenuesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author liuxiaojie
 *
 * 分类表  Service实现类
 * */
@Service
public class VenuesServiceImpl implements VenuesService {
    @Autowired
    private VenuesDao venuesDao;
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void save(Object obj) {
        //因添加数据时获取不到id，无法将此obj设置到缓存中，所以直接将数据保存在数据库中即可
        venuesDao.save(obj);
    }

    @Override
    public void removeById(Long id) {
        venuesDao.removeById(id);

        //先判断缓存中是否存在此键 key,若存在则删除此键
        Boolean key_exist = redisTemplate.hasKey("venues-"+id);
        if (key_exist) {
            redisTemplate.delete("venues-"+id);
        }
    }

    @Override
    public void update(Object obj) {
        //先修改数据库中的值
        venuesDao.update(obj);

        //查询缓存中是否有此数据值
        ValueOperations<String,Venues> valueOperations = redisTemplate.opsForValue();
        Venues venues = (Venues) obj;
        Venues venues1 = valueOperations.get("venues-"+venues.getVid());
        //若存在此数据则重新设置缓存值
        if(venues1!=null){
            valueOperations.set("venues-"+venues.getVid(),venues);
        }
    }

    @Override
    public Object getById(Long id) {
        Venues venues = null;
        venues = (Venues) redisTemplate.opsForValue().get("venues-"+id);
        //若缓存中没有对应的数据则去数据库中查找，若有此数据则直接从缓存中取值
        if (venues == null) {
            venues = (Venues) venuesDao.getById(id);
            if (venues != null) {
                redisTemplate.opsForValue().set("venues-"+id,venues);
            }
        }
        return venues;
    }

    @Override
    public List<Object> listAll() {
        List<Object> venuesList = new ArrayList<>();
        List<Object> redisList = new ArrayList<>();

        Set<Object> redisSet= redisTemplate.keys("venues-*");
        Long countAll = this.count();
        //说明缓存中有数据
        if (redisSet != null && redisSet.size()==countAll) {
            Iterator<Object> iter = redisSet.iterator();
            while (iter.hasNext()) {
                Venues venues = (Venues) redisTemplate.opsForValue().get(iter.next());
                redisList.add(venues);
            }
            return redisList;
        }else {
            //从数据库中获取数据
            venuesList = venuesDao.listAll();
            if (venuesList != null && venuesList.size() != 0 ) {
                Iterator iter = venuesList.iterator();
                while (iter.hasNext()) {
                    Venues venues = (Venues) iter.next();
                    redisTemplate.opsForValue().set("venues-"+venues.getVid(),venues);
                }
            }
            return venuesList;
        }
    }

    @Override
    public Long count() {
        return venuesDao.count();
    }
}
