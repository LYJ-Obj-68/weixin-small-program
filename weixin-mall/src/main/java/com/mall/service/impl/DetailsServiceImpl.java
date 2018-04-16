package com.mall.service.impl;

import com.mall.bean.Details;
import com.mall.dao.DetailsDao;
import com.mall.service.DetailsService;
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
 * 详情表  Service实现类
 * */
@Service
public class DetailsServiceImpl implements DetailsService {
    @Autowired
    private DetailsDao detailsDao;
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void save(Object obj) {
        //因添加数据时获取不到id，无法将此obj设置到缓存中，所以直接将数据保存在数据库中即可
        detailsDao.save(obj);
    }

    @Override
    public void removeById(Long id) {
        detailsDao.removeById(id);

        //先判断缓存中是否存在此键 key,若存在则删除此键
        Boolean key_exist = redisTemplate.hasKey("details-"+id);
        if (key_exist) {
            redisTemplate.delete("details-"+id);
        }
    }

    @Override
    public void update(Object obj) {
        //先修改数据库中的值
        detailsDao.update(obj);

        //查询缓存中是否有此数据值
        ValueOperations<String,Details> valueOperations = redisTemplate.opsForValue();
        Details details = (Details) obj;
        Details details1 = valueOperations.get("details-"+details.getDid());
        //若存在此数据则重新设置缓存值
        if(details1!=null){
            valueOperations.set("details-"+details.getDid(),details);
        }
    }

    @Override
    public Object getById(Long id) {
        Details details = null;
        details = (Details) redisTemplate.opsForValue().get("details-"+id);
        //若缓存中没有对应的数据则去数据库中查找，若有此数据则直接从缓存中取值
        if (details == null) {
            details = (Details) detailsDao.getById(id);
            if (details != null) {
                redisTemplate.opsForValue().set("details-"+id,details);
            }
        }
        return details;
    }

    @Override
    public List<Object> listAll() {
        List<Object> detailsList = new ArrayList<>();
        List<Object> redisList = new ArrayList<>();

        Set<Object> redisSet= redisTemplate.keys("details-*");
        Long countAll = this.count();
        //说明缓存中有数据
        if (redisSet != null && redisSet.size()==countAll) {
            Iterator<Object> iter = redisSet.iterator();
            while (iter.hasNext()) {
                Details details = (Details) redisTemplate.opsForValue().get(iter.next());
                redisList.add(details);
            }
            return redisList;
        }else {
            //从数据库中获取数据
            detailsList = detailsDao.listAll();
            if (detailsList != null && detailsList.size() != 0 ) {
                Iterator iter = detailsList.iterator();
                while (iter.hasNext()) {
                    Details details = (Details) iter.next();
                    redisTemplate.opsForValue().set("details-"+details.getDid(),details);
                }
            }
            return detailsList;
        }
    }

    @Override
    public Long count() {
        return detailsDao.count();
    }

    @Override
    public List<Details> listByVid(Long vid) {
        return detailsDao.listByVid(vid);
    }
}
